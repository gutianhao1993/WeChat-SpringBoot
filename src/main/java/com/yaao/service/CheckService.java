package com.yaao.service;

import java.util.List;

/**
 * 检查账号与微信号是否满足绑定条件服务类
 *
 * @author GuTianHao
 */
public interface CheckService {
    /**
     * 检查微信号是否被绑定
     *
     * @param openID
     * @return
     */
    public List<String> checkInfo(String openID);
}
