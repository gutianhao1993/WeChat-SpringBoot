package com.yaao.service.impl;

import com.yaao.dao.AreaDao;
import com.yaao.entity.Area;
import com.yaao.entity.Multiselect;
import com.yaao.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 地区服务接口实现类
 *
 * @author GuTianHao
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Resource
    private AreaDao areaDao;

    @Override
    public List<Multiselect> getAreas() {
        List<Area> areas = areaDao.getAreas();
        if (areas == null) {
            throw new RuntimeException("地区信息不存在!");
        }

        List<Multiselect> list = new ArrayList<>();
        List<Long> ids = new ArrayList<>();
        List<Long> pids = new ArrayList<>();

        for (Area area : areas) {
            ids.add(area.getAreaID());
            pids.add(area.getParentID());
        }
        //所有一级选项
        for (Area area : areas) {
            if (!ids.contains(area.getParentID())) {
                Multiselect multiselect = new Multiselect();
                multiselect.setId(area.getAreaID());
                multiselect.setValue(area.getAreaName());
                multiselect.setNodeType(area.getNodeType());
                list.add(multiselect);
            }

        }
        //设置子级选项
        for (Multiselect m : list) {
            m.setChilds(getChild(m.getId(), pids, areas));
        }

        return list;
    }

    @Override
    public List<Area> getLocations() {
        List<Area> locations = areaDao.getAreas();
        return locations;
    }

    @Override
    public List<Area> getSubLocations(Long areaID) {
        List<Area> subLocations = areaDao.getSubLocations(areaID);
        return subLocations;
    }

    @Override
    public List<String> getSuNames() {
        List<String> list = areaDao.getSuNames();
        return list;
    }

    /**
     * @param id
     * @param pids
     * @param areas
     * @return
     */
    public List<Multiselect> getChild(Long id, List<Long> pids, List<Area> areas) {
        List<Multiselect> child = new ArrayList<>();
        for (Area area : areas) {
            // 遍历所有节点，将其pId与传过来的id比较
            if (area.getParentID().equals(id)) {
                Multiselect multiselect = new Multiselect();
                multiselect.setId(area.getAreaID());
                multiselect.setValue(area.getAreaName());
                multiselect.setNodeType(area.getNodeType());
                child.add(multiselect);
            }
        }
        for (Multiselect mul : child) {
            if (pids.contains(mul.getId())) {
                mul.setChilds(getChild(mul.getId(), pids, areas));
            }
        }
        if (child.size() == 0) {
            return null;
        }
        return child;
    }
}
