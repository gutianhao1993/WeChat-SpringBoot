package com.yaao.service;

/**
 * 解绑微信号与Basic_UserTable账号
 *
 * @author GuTianHao
 */
public interface UnbindingService {
    /**
     * 解绑账号
     * @param openID
     */
    void unbinding(String openID);
}
