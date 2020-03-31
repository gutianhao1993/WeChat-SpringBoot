package com.yaao.entity;

import java.io.Serializable;

/**
 * 实时数据实体类
 *
 * @author GuTianHao
 */
public class RealTimeData implements Serializable {

    private static final long serialVersionUID = -1882742300698079920L;

    private String SoName;
    private Integer AlarmLevel;
    private String FSUName;
    private String AreaName;

    public String getSoName() {
        return SoName;
    }

    public void setSoName(String soName) {
        SoName = soName;
    }

    public Integer getAlarmLevel() {
        return AlarmLevel;
    }

    public void setAlarmLevel(Integer alarmLevel) {
        AlarmLevel = alarmLevel;
    }

    public String getFSUName() {
        return FSUName;
    }

    public void setFSUName(String FSUName) {
        this.FSUName = FSUName;
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }

    @Override
    public String toString() {
        return "RealTimeData{" +
                "SoName='" + SoName + '\'' +
                ", AlarmLevel=" + AlarmLevel +
                ", FSUName='" + FSUName + '\'' +
                ", AreaName='" + AreaName + '\'' +
                '}';
    }
}
