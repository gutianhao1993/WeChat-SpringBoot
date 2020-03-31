package com.yaao.controller;

import com.yaao.service.SendMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


/**
 * 推送模板信息
 *
 * @author GuTianHao
 */

@Controller
public class SendMessageController {
    @Resource
    private SendMessageService sendMessageService;

    @RequestMapping("sendMessage.do")
    public void sendMessage() {
        sendMessageService.sendTemplateMsg();
    }

}
