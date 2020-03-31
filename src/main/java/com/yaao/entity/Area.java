package com.yaao.entity;

import java.io.Serializable;

/**
 * 地区实体类
 *
 * @author GuTianHao
 */
public class Area implements Serializable {

    private static final long serialVersionUID = 5140141731203902530L;

    private Long AreaID;
    private Long ParentID;
    private Integer Layer;
    private String AreaName;
    private Integer NodeType;
    private Integer SoType;
    private String ImgUrl;
    private Integer HasSubNode;
    private String Dsc;
    private String ResourceID;
    private String ParentPath;

    public Long getAreaID() {
        return AreaID;
    }

    public void setAreaID(Long areaID) {
        AreaID = areaID;
    }

    public Long getParentID() {
        return ParentID;
    }

    public void setParentID(Long parentID) {
        ParentID = parentID;
    }

    public Integer getLayer() {
        return Layer;
    }

    public void setLayer(Integer layer) {
        Layer = layer;
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }

    public Integer getNodeType() {
        return NodeType;
    }

    public void setNodeType(Integer nodeType) {
        NodeType = nodeType;
    }

    public Integer getSoType() {
        return SoType;
    }

    public void setSoType(Integer soType) {
        SoType = soType;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public Integer getHasSubNode() {
        return HasSubNode;
    }

    public void setHasSubNode(Integer hasSubNode) {
        HasSubNode = hasSubNode;
    }

    public String getDsc() {
        return Dsc;
    }

    public void setDsc(String dsc) {
        Dsc = dsc;
    }

    public String getResourceID() {
        return ResourceID;
    }

    public void setResourceID(String resourceID) {
        ResourceID = resourceID;
    }

    public String getParentPath() {
        return ParentPath;
    }

    public void setParentPath(String parentPath) {
        ParentPath = parentPath;
    }

    @Override
    public String toString() {
        return "Area{" +
                "AreaID=" + AreaID +
                ", ParentID=" + ParentID +
                ", Layer=" + Layer +
                ", AreaName='" + AreaName + '\'' +
                ", NodeType=" + NodeType +
                ", SoType=" + SoType +
                ", ImgUrl='" + ImgUrl + '\'' +
                ", HasSubNode=" + HasSubNode +
                ", Dsc='" + Dsc + '\'' +
                ", ResourceID='" + ResourceID + '\'' +
                ", ParentPath='" + ParentPath + '\'' +
                '}';
    }
}
