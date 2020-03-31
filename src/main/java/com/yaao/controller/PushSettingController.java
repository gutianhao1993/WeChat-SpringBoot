package com.yaao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GuTianHao
 */
@Controller
public class PushSettingController {
    @RequestMapping("pushSetting.do")
    public String pushSetting() {
        return "pushSetting";
    }
}
