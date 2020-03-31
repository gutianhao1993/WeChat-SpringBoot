package com.yaao.controller;

import com.yaao.service.UnbindingService;
import com.yaao.util.OpenIDUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 解绑微信号与Basic_UserTable账号
 *
 * @author GuTianHao
 */
@Controller
public class UnbindingController {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private UnbindingService unbindingService;

    @RequestMapping("unbinding.do")
    public void unBinding(HttpServletRequest request, HttpServletResponse response) {
        String openID = OpenIDUtil.getOpenIDByInterfaceOrSession(request, response);
        try {
            unbindingService.unbinding(openID);
            logger.info("解绑成功!");
        } catch (Exception e) {
            logger.error("解绑失败");
            e.printStackTrace();
        }
    }
}
