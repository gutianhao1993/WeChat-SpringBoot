package com.yaao.entity;

import java.util.Arrays;

/**
 * 微信自定义菜单
 *
 * @author GuTianHao
 */
public class ComplexButton extends Button {
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 子级菜单
     */
    private Button[] sub_button;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }

    @Override
    public String toString() {
        return "ComplexButton{" +
                "name='" + name + '\'' +
                ", sub_button=" + Arrays.toString(sub_button) +
                '}';
    }
}
