package com.yaao.dao;

import com.yaao.entity.Alarm;
import org.apache.ibatis.annotations.Param;

/**
 * 获取告警详细信息
 *
 * @author GuTianHao
 */
public interface DetailInfoDao {
    /**
     * 获取告警详情(推送)
     *
     * @param id
     * @return
     */
    Alarm getDetailInfo(@Param("ID") Integer id);

    /**
     * 获取告警详情(自定义菜单)
     *
     * @param alarmID
     * @return
     */
    Alarm getAlarmDetailInfo(@Param("alarmID") Long alarmID);


}
