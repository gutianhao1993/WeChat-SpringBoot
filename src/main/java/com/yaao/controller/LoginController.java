package com.yaao.controller;


import com.yaao.service.CheckService;
import com.yaao.util.OpenIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 绑定界面
 *
 * @author GuTianHao
 */

@Controller
public class LoginController {
    @Resource
    private CheckService checkService;

    @RequestMapping("login.do")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String openID = OpenIDUtil.getOpenIDByInterfaceOrSession(request, response);
        //验证openID是否被绑定至账号
        List<String> list = checkService.checkInfo(openID);

        //若被绑定,重定向至个人信息页面;若未被绑定,放行
        if (list == null || list.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("openID", openID);
            return "login";
        } else {
            return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7c93014354297ece&redirect_uri=http%3a%2f%2fsuser.cn%2fWeChat%2finfo.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
        }
    }
}
