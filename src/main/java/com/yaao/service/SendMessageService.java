package com.yaao.service;

/**
 * 推送告警模板消息服务类
 *
 * @author GuTianHao
 */
public interface SendMessageService {
    /**
     * 发送信息
     */
    void sendTemplateMsg();

    /**
     * 重发信息
     */
    void resendTemplateMsg();

    /**
     * 设置失效告警信息
     */
    void setExpireMsg();
}
