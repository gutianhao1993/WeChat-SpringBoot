package com.yaao.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 验证微信号是否被绑定
 *
 * @author GuTianHao
 */
public interface CheckInfoDao {
    /**
     * 检查微信号是否被绑定
     *
     * @param openID
     * @return
     */
    List<String> checkInfo(@Param("openID") String openID);
}
