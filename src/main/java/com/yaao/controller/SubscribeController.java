package com.yaao.controller;

import com.yaao.service.SubscribeService;
import com.yaao.util.SignUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 订阅事件
 *
 * @author GuTianHao
 */

@Controller
public class SubscribeController {

    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private SubscribeService subscribeService;

    /**
     * 微信接入
     *
     * @param
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "subscribe.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void connectWeixin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //将请求、响应的编码均设置为UTF-8（防止中文乱码）
        //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        request.setCharacterEncoding("UTF-8");
        //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
        response.setCharacterEncoding("UTF-8");
        boolean isGet = "get".equals(request.getMethod().toLowerCase());

        PrintWriter out = response.getWriter();

        try {
            if (isGet) {
                // 微信加密签名
                String signature = request.getParameter("signature");
                // 时间戳
                String timestamp = request.getParameter("timestamp");
                // 随机数
                String nonce = request.getParameter("nonce");
                //随机字符串
                String echostr = request.getParameter("echostr");

                // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败

                if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                    logger.info("Connect the weixin server is successful.");
                    response.getWriter().write(echostr);
                } else {

                }
            } else {
                String respMessage = null;
                try {
                    respMessage = subscribeService.wechatPost(request);
                    out.write(respMessage);

                    logger.info("The request completed successfully");
                    logger.info("to weixin server " + respMessage);
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            logger.error("Connect the weixin server is error.");
        } finally {
            out.close();
        }
    }
}
