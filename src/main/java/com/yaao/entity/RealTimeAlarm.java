package com.yaao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实时告警实体类
 *
 * @author GuTianHao
 */
public class RealTimeAlarm implements Serializable {

    private static final long serialVersionUID = -1882742300698079920L;

    private Long AlarmID;
    private Integer AlarmLevel;
    private Long SoCode;
    private String AreaName;
    private String Dsc;
    private String SoName;
    private String StartTime;

    public Long getAlarmID() {
        return AlarmID;
    }

    public void setAlarmID(Long alarmID) {
        AlarmID = alarmID;
    }

    public Integer getAlarmLevel() {
        return AlarmLevel;
    }

    public void setAlarmLevel(Integer alarmLevel) {
        AlarmLevel = alarmLevel;
    }

    public Long getSoCode() {
        return SoCode;
    }

    public void setSoCode(Long soCode) {
        SoCode = soCode;
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }

    public String getDsc() {
        return Dsc;
    }

    public void setDsc(String dsc) {
        Dsc = dsc;
    }

    public String getSoName() {
        return SoName;
    }

    public void setSoName(String soName) {
        SoName = soName;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    @Override
    public String toString() {
        return "RealTimeAlarm{" +
                "AlarmID=" + AlarmID +
                ", AlarmLevel=" + AlarmLevel +
                ", SoCode=" + SoCode +
                ", AreaName='" + AreaName + '\'' +
                ", Dsc='" + Dsc + '\'' +
                ", SoName='" + SoName + '\'' +
                ", StartTime='" + StartTime + '\'' +
                '}';
    }
}
