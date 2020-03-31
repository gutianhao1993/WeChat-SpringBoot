package com.yaao.controller;


import com.yaao.service.CheckService;
import com.yaao.util.OpenIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 用户个人信息
 *
 * @author GuTianHao
 */
@Controller
public class InfoController {
    @Resource
    private CheckService checkService;

    @RequestMapping("info.do")
    public String info(HttpServletRequest request, HttpServletResponse response) {
        String openID = OpenIDUtil.getOpenIDByInterfaceOrSession(request, response);
        //验证openID是否被绑定至账号
        List<String> list = checkService.checkInfo(openID);
        //未被绑定,重定向至绑定页面,若已被绑定,通过session保存绑定的账号及openID
        if (list == null || list.isEmpty()) {
            return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7c93014354297ece&redirect_uri=http%3a%2f%2fsuser.cn%2fWeChat%2flogin.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
        } else {
            String result = list.get(0);
            HttpSession session = request.getSession();
            session.setAttribute("result", result);
            session.setAttribute("openID", openID);
            return "info";
        }
    }
}
