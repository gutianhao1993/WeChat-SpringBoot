package com.yaao.service;

import java.util.Map;

/**
 * 实时告警服务类
 *
 * @author GuTianHao
 */
public interface RealTimeAlarmService {
    /**
     * 获取告警
     *
     * @param areaName
     * @param startTime
     * @param alarmLevel
     * @param areaID
     * @param pageCurrent
     * @param pageSize
     * @return
     */
    Map<String, Object> getRealTimeAlarm(String areaName, String startTime, Integer alarmLevel,
                                         String areaID, Integer pageCurrent, Integer pageSize);
}
