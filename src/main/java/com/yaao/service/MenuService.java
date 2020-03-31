package com.yaao.service;

import com.yaao.entity.Menu;

/**
 * 微信自定义菜单服务类
 *
 * @author GuTianHao
 */
public interface MenuService {
    /**
     * Menu对象信息
     *
     * @return
     */
    public Menu getMenu();

    /**
     * 创建Menu
     *
     * @param menu
     * @return
     */
    public int createMenu(Menu menu);
}
