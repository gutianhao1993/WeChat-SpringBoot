package com.yaao.entity;

/**
 * @author GuTianHao
 */
public class So {

    private long id;
    private long fsuid;
    private long suCode;
    private long soCode;
    private long soType;
    private long soSubType;
    private long deviceCode;
    private double longitude;
    private double latitude;
    private long res3;
    private String soName;
    private String deviceId;
    private String nodeDesc;
    private String productor;
    private String version;
    private java.sql.Timestamp beginRunTime;
    private String deviceModel;
    private String roomid;
    private String roomName;
    private long siteId;
    private String siteName;
    private double ratedCapacity;
    private String confremark;
    private long eraseflag;
    private long res;
    private long gateId;
    private String gmtModified;
    private long areaId;
    private String areaName;
    private String parentPath;
    private long projectId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFsuid() {
        return fsuid;
    }

    public void setFsuid(long fsuid) {
        this.fsuid = fsuid;
    }

    public long getSuCode() {
        return suCode;
    }

    public void setSuCode(long suCode) {
        this.suCode = suCode;
    }

    public long getSoCode() {
        return soCode;
    }

    public void setSoCode(long soCode) {
        this.soCode = soCode;
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

    public long getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(long deviceCode) {
        this.deviceCode = deviceCode;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public long getRes3() {
        return res3;
    }

    public void setRes3(long res3) {
        this.res3 = res3;
    }

    public String getSoName() {
        return soName;
    }

    public void setSoName(String soName) {
        this.soName = soName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getNodeDesc() {
        return nodeDesc;
    }

    public void setNodeDesc(String nodeDesc) {
        this.nodeDesc = nodeDesc;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public java.sql.Timestamp getBeginRunTime() {
        return beginRunTime;
    }

    public void setBeginRunTime(java.sql.Timestamp beginRunTime) {
        this.beginRunTime = beginRunTime;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public double getRatedCapacity() {
        return ratedCapacity;
    }

    public void setRatedCapacity(double ratedCapacity) {
        this.ratedCapacity = ratedCapacity;
    }

    public String getConfremark() {
        return confremark;
    }

    public void setConfremark(String confremark) {
        this.confremark = confremark;
    }

    public long getEraseflag() {
        return eraseflag;
    }

    public void setEraseflag(long eraseflag) {
        this.eraseflag = eraseflag;
    }

    public long getRes() {
        return res;
    }

    public void setRes(long res) {
        this.res = res;
    }

    public long getGateId() {
        return gateId;
    }

    public void setGateId(long gateId) {
        this.gateId = gateId;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }


    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "So{" +
                "id=" + id +
                ", fsuid=" + fsuid +
                ", suCode=" + suCode +
                ", soCode=" + soCode +
                ", soType=" + soType +
                ", soSubType=" + soSubType +
                ", deviceCode=" + deviceCode +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", res3=" + res3 +
                ", soName='" + soName + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", nodeDesc='" + nodeDesc + '\'' +
                ", productor='" + productor + '\'' +
                ", version='" + version + '\'' +
                ", beginRunTime=" + beginRunTime +
                ", deviceModel='" + deviceModel + '\'' +
                ", roomid='" + roomid + '\'' +
                ", roomName='" + roomName + '\'' +
                ", siteId=" + siteId +
                ", siteName='" + siteName + '\'' +
                ", ratedCapacity=" + ratedCapacity +
                ", confremark='" + confremark + '\'' +
                ", eraseflag=" + eraseflag +
                ", res=" + res +
                ", gateId=" + gateId +
                ", gmtModified=" + gmtModified +
                ", areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", parentPath='" + parentPath + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
