package com.yaao.entity;

/**
 * @author GuTianHao
 */
public class SensorFormat {

    private long id;
    private long soType;
    private long soSubType;
    private long sensorCode;
    private long nodeId;
    private long senPrecision;
    private long attrib;
    private long sensorType;
    private long res1;
    private String modeNo;
    private long checkFlag;
    private long res3;
    private long res4;
    private double alarmThresbhold;
    private double highLimit;
    private double lowLimit;
    private double highNormal;
    private double lowNormal;
    private double dataModify;
    private long alarmEnable;
    private long alarmFlag;
    private long saveFlag;
    private long saveSpan;
    private double relativeVal;
    private double absoluteVal;
    private String unit;
    private String standardId;
    private String sensorName;
    private String dataDesc;
    private String nmAlarmId;
    private long alarmLevel;
    private long overHigh;
    private double thresbhold;
    private double thresbhold2;
    private long mainStandardId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getSoType() {
        return soType;
    }

    public void setSoType(long soType) {
        this.soType = soType;
    }


    public long getSoSubType() {
        return soSubType;
    }

    public void setSoSubType(long soSubType) {
        this.soSubType = soSubType;
    }


    public long getSensorCode() {
        return sensorCode;
    }

    public void setSensorCode(long sensorCode) {
        this.sensorCode = sensorCode;
    }


    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }


    public long getSenPrecision() {
        return senPrecision;
    }

    public void setSenPrecision(long senPrecision) {
        this.senPrecision = senPrecision;
    }


    public long getAttrib() {
        return attrib;
    }

    public void setAttrib(long attrib) {
        this.attrib = attrib;
    }


    public long getSensorType() {
        return sensorType;
    }

    public void setSensorType(long sensorType) {
        this.sensorType = sensorType;
    }


    public long getRes1() {
        return res1;
    }

    public void setRes1(long res1) {
        this.res1 = res1;
    }


    public String getModeNo() {
        return modeNo;
    }

    public void setModeNo(String modeNo) {
        this.modeNo = modeNo;
    }


    public long getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(long checkFlag) {
        this.checkFlag = checkFlag;
    }


    public long getRes3() {
        return res3;
    }

    public void setRes3(long res3) {
        this.res3 = res3;
    }


    public long getRes4() {
        return res4;
    }

    public void setRes4(long res4) {
        this.res4 = res4;
    }


    public double getAlarmThresbhold() {
        return alarmThresbhold;
    }

    public void setAlarmThresbhold(double alarmThresbhold) {
        this.alarmThresbhold = alarmThresbhold;
    }


    public double getHighLimit() {
        return highLimit;
    }

    public void setHighLimit(double highLimit) {
        this.highLimit = highLimit;
    }


    public double getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(double lowLimit) {
        this.lowLimit = lowLimit;
    }


    public double getHighNormal() {
        return highNormal;
    }

    public void setHighNormal(double highNormal) {
        this.highNormal = highNormal;
    }


    public double getLowNormal() {
        return lowNormal;
    }

    public void setLowNormal(double lowNormal) {
        this.lowNormal = lowNormal;
    }


    public double getDataModify() {
        return dataModify;
    }

    public void setDataModify(double dataModify) {
        this.dataModify = dataModify;
    }


    public long getAlarmEnable() {
        return alarmEnable;
    }

    public void setAlarmEnable(long alarmEnable) {
        this.alarmEnable = alarmEnable;
    }


    public long getAlarmFlag() {
        return alarmFlag;
    }

    public void setAlarmFlag(long alarmFlag) {
        this.alarmFlag = alarmFlag;
    }


    public long getSaveFlag() {
        return saveFlag;
    }

    public void setSaveFlag(long saveFlag) {
        this.saveFlag = saveFlag;
    }


    public long getSaveSpan() {
        return saveSpan;
    }

    public void setSaveSpan(long saveSpan) {
        this.saveSpan = saveSpan;
    }


    public double getRelativeVal() {
        return relativeVal;
    }

    public void setRelativeVal(double relativeVal) {
        this.relativeVal = relativeVal;
    }


    public double getAbsoluteVal() {
        return absoluteVal;
    }

    public void setAbsoluteVal(double absoluteVal) {
        this.absoluteVal = absoluteVal;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }


    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }


    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }


    public String getNmAlarmId() {
        return nmAlarmId;
    }

    public void setNmAlarmId(String nmAlarmId) {
        this.nmAlarmId = nmAlarmId;
    }


    public long getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(long alarmLevel) {
        this.alarmLevel = alarmLevel;
    }


    public long getOverHigh() {
        return overHigh;
    }

    public void setOverHigh(long overHigh) {
        this.overHigh = overHigh;
    }


    public double getThresbhold() {
        return thresbhold;
    }

    public void setThresbhold(double thresbhold) {
        this.thresbhold = thresbhold;
    }


    public double getThresbhold2() {
        return thresbhold2;
    }

    public void setThresbhold2(double thresbhold2) {
        this.thresbhold2 = thresbhold2;
    }


    public long getMainStandardId() {
        return mainStandardId;
    }

    public void setMainStandardId(long mainStandardId) {
        this.mainStandardId = mainStandardId;
    }

    @Override
    public String toString() {
        return "SensorFormat{" +
                "id=" + id +
                ", soType=" + soType +
                ", soSubType=" + soSubType +
                ", sensorCode=" + sensorCode +
                ", nodeId=" + nodeId +
                ", senPrecision=" + senPrecision +
                ", attrib=" + attrib +
                ", sensorType=" + sensorType +
                ", res1=" + res1 +
                ", modeNo='" + modeNo + '\'' +
                ", checkFlag=" + checkFlag +
                ", res3=" + res3 +
                ", res4=" + res4 +
                ", alarmThresbhold=" + alarmThresbhold +
                ", highLimit=" + highLimit +
                ", lowLimit=" + lowLimit +
                ", highNormal=" + highNormal +
                ", lowNormal=" + lowNormal +
                ", dataModify=" + dataModify +
                ", alarmEnable=" + alarmEnable +
                ", alarmFlag=" + alarmFlag +
                ", saveFlag=" + saveFlag +
                ", saveSpan=" + saveSpan +
                ", relativeVal=" + relativeVal +
                ", absoluteVal=" + absoluteVal +
                ", unit='" + unit + '\'' +
                ", standardId='" + standardId + '\'' +
                ", sensorName='" + sensorName + '\'' +
                ", dataDesc='" + dataDesc + '\'' +
                ", nmAlarmId='" + nmAlarmId + '\'' +
                ", alarmLevel=" + alarmLevel +
                ", overHigh=" + overHigh +
                ", thresbhold=" + thresbhold +
                ", thresbhold2=" + thresbhold2 +
                ", mainStandardId=" + mainStandardId +
                '}';
    }
}
