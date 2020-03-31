package com.yaao.entity;

/**
 * 微信自定义菜单
 *
 * @author GuTianHao
 */
public class ViewButton extends Button {
    /**
     * 菜单类型
     */
    private String type;
    /**
     * view路径值
     */
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
