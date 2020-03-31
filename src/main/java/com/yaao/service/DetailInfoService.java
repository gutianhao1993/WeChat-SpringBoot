package com.yaao.service;

import java.util.Map;

/**
 * 告警详情服务类
 *
 * @author GuTianHao
 */
public interface DetailInfoService {
    /**
     * 获取告警详情(推送)
     *
     * @param id
     * @return
     */
    Map<String, Object> getDetailInfo(Integer id);

    /**
     * 获取告警详情(自定义菜单)
     *
     * @param alarmID
     * @return
     */
    Map<String, Object> getAlarmlDetailInfo(Long alarmID);
}