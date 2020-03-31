package com.yaao.dao;

import com.yaao.entity.RealTimeAlarm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 实时告警
 *
 * @author GuTianHao
 */
public interface RealTimeAlarmDao {
    /**
     * 获取实时告警
     *
     * @param areaName
     * @param startTime
     * @param alarmLevel
     * @param areaID
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<RealTimeAlarm> getRealTimeAlarm(@Param("areaName") String areaName,
                                         @Param("startTime") String startTime,
                                         @Param("alarmLevel") Integer alarmLevel,
                                         @Param("areaID") String areaID,
                                         @Param("startIndex") Integer startIndex,
                                         @Param("pageSize") Integer pageSize);


    /**
     * 获取告警数量
     *
     * @param areaName
     * @param startTime
     * @param alarmLevel
     * @param areaID
     * @return
     */
    int getRowCount(@Param("areaName") String areaName,
                    @Param("startTime") String startTime,
                    @Param("alarmLevel") Integer alarmLevel,
                    @Param("areaID") String areaID);
}
