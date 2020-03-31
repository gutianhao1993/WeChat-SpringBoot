package com.yaao.dao;

import com.yaao.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 绑定账号
 *
 * @author GuTianHao
 */
public interface BindingDao {
    /**
     * 查询User
     *
     * @param logName
     * @return
     */
    User findUserByName(@Param("logName") String logName);

    /**
     * 绑定openID
     *
     * @param openID
     * @param userID
     * @param logName
     * @param createTime
     * @param updateTime
     */
    void addOpenID(@Param("openID") String openID, @Param("userID") Integer userID, @Param("logName") String logName,
                   @Param("createTime") String createTime, @Param("updateTime") String updateTime);

    /**
     * 检查微信号是否被绑定
     *
     * @param openID
     * @return
     */
    List<String> checkOpenID(@Param("openID") String openID);

    /**
     * 检查账号是否被绑定
     *
     * @param logName
     * @return
     */
    List<String> checkLogName(@Param("logName") String logName);
}
