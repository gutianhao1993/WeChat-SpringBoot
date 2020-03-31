package com.yaao.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 解绑微信号与Basic_UserTable账号
 *
 * @author GuTianHao
 */
public interface UnbindingDao {
    /**
     * 解绑
     *
     * @param openID
     */
    void unbinding(@Param("openID") String openID);
}
