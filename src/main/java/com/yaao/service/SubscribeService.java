package com.yaao.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 订阅消息服务类(微信交互)
 *
 * @author GuTianHao
 */
public interface SubscribeService {
    /**
     * 订阅事件
     *
     * @param request
     * @return
     */
    String wechatPost(HttpServletRequest request);
}
