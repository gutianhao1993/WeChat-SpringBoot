package com.yaao.controller;

import com.yaao.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 创建自定义菜单
 *
 * @author GuTianHao
 */

@Controller
public class MenuController {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Resource
    private MenuService menuService;

    @RequestMapping("createMenu.do")
    public void createMenu() {
        //调用UTI执行创建菜单的动作
        int status = menuService.createMenu(menuService.getMenu());
        if (status == 0) {
            logger.info("菜单创建成功！");
        } else {
            logger.error("菜单创建失败！");
        }
    }
}
