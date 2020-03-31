package com.yaao.controller;

import com.yaao.entity.User;
import com.yaao.service.BindingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账号登录(绑定)
 *
 * @author GuTianHao
 */

@Controller
public class BindingController {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private BindingService bindingService;

    @RequestMapping("bind.do")
    public String bindUser(HttpServletRequest request, HttpSession session) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String openID = (String) session.getAttribute("openID");

        //验证openID是否为null
        if (openID == null) {
            logger.error("未能正确获取到openID");
            return "redirect:error4.do";
        }
        //验证账号是否已经被绑定
        List<String> user_LogName = bindingService.checkLogName(name);
        if (user_LogName != null && !user_LogName.isEmpty()) {
            logger.error("该账号已被绑定!");
            return "redirect:error3.do";
        }
        //验证账号密码
        Map<String, Object> map = new HashMap<String, Object>(100);
        map = bindingService.checkUser(name, password, openID);
        User user = (User) map.get("user");
        List<String> list = (List<String>) map.get("list");

        //账号错误
        if (user == null) {
            logger.error("输入账号不存在或密码错误!");
            return "redirect:error1.do";
        }
        //密码错误
        if (list != null && !list.isEmpty()) {
            logger.error("该微信号已经被绑定,请勿重复绑定!");
            return "redirect:error2.do";
        }

        Integer userID = user.getUseID();
        String logName = user.getLogName();

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String createTime = sdf.format(System.currentTimeMillis());
        String updateTime = sdf.format(System.currentTimeMillis());

        //绑定openID,insert至UserBindingTable
        bindingService.addOpenID(openID, userID, logName, createTime, updateTime);
        session.setAttribute("logName", logName);
        session.setAttribute("openID", openID);
        logger.info("微信号绑定成功!");
        return "redirect:success.do";
    }

    @RequestMapping("success.do")
    public String success() {
        return "success";
    }

    @RequestMapping("error1.do")
    public String error1() {
        return "error1";
    }

    @RequestMapping("error2.do")
    public String error2() {
        return "error2";
    }

    @RequestMapping("error3.do")
    public String error3() {
        return "error3";
    }

    @RequestMapping("error4.do")
    public String error4() {
        return "error4";
    }
}
