package com.yaao.dao;

import com.yaao.entity.SensorFormat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SensorFormatTable
 *
 * @author GuTianHao
 */
public interface SensorDao {
    /**
     * 获取所有SensorFormat对象
     *
     * @return
     */
    List<SensorFormat> getAllSensor();

    /**
     * 根据SensorCode获取SensorFormat对象
     *
     * @param sensorCode
     * @return
     */
    List<SensorFormat> getSensorFormatBySensorCode(@Param("sensorCode") String sensorCode);
}
