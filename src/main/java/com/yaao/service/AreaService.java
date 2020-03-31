package com.yaao.service;

import com.yaao.entity.Area;
import com.yaao.entity.Multiselect;


import java.util.List;

/**
 * 地区服务类
 *
 * @author GuTianHao
 */
public interface AreaService {
    /**
     * 获取地区信息(树形)
     *
     * @return
     */
    List<Multiselect> getAreas();

    /**
     * 获取地区信息
     *
     * @return
     */
    List<Area> getLocations();

    /**
     * 获取子级地区信息
     *
     * @param areaID
     * @return
     */
    List<Area> getSubLocations(Long areaID);

    /**
     * 获取所有机房名称
     *
     * @return
     */
    List<String> getSuNames();
}
