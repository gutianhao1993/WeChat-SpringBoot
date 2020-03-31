package com.yaao.service;

import java.util.List;
import java.util.Map;

/**
 * 绑定账号微信号服务类
 *
 * @author GuTianHao
 */
public interface BindingService {
    /**
     * 检查账号密码
     *
     * @param logName
     * @param password
     * @param openID
     * @return
     */
    Map<String, Object> checkUser(String logName, String password, String openID);

    /**
     * 绑定openID
     *
     * @param openID
     * @param userID
     * @param logName
     * @param createTime
     * @param updateTime
     */
    void addOpenID(String openID, Integer userID, String logName, String createTime, String updateTime);

    /**
     * 检查账号是否已经被绑定
     *
     * @param logName
     * @return
     */
    List<String> checkLogName(String logName);
}
