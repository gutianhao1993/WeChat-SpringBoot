package com.yaao.entity;

/**
 * 微信自定义菜单
 *
 * @author GuTianHao
 */
public class Menu extends Button {
    private ComplexButton[] button;

    public ComplexButton[] getButton() {
        return button;
    }

    public void setButton(ComplexButton[] button) {
        this.button = button;
    }
}
