package com.yaao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GuTianHao
 */

@Controller
public class NoResultController {
    @RequestMapping("noResult.do")
    public String noResult() {
        return "noResult";
    }
}
