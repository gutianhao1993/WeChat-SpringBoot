package com.yaao.dao;

import com.yaao.entity.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地区信息
 *
 * @author GuTianHao
 */
public interface AreaDao {
    /**
     * 获取地区信息
     *
     * @return
     */
    List<Area> getAreas();

    /**
     * 获取areaID对应地区的子级地区
     *
     * @param areaID
     * @return
     */
    List<Area> getSubLocations(@Param("areaID") Long areaID);

    /**
     * 获取所有机房名称
     *
     * @return
     */
    List<String> getSuNames();

    /**
     * 根据AreaID获取Area对象
     *
     * @param areaID
     * @return
     */
    Area getAreaByAreaId(@Param("areaID") Long areaID);
}
