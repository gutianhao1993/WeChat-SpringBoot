package com.yaao.controller;

import com.yaao.entity.Area;
import com.yaao.entity.Multiselect;
import com.yaao.service.AreaService;
import com.yaao.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.List;

/**
 * MultiSelect插件 迭代地区树
 * @author GuTianHao
 */
@Controller
public class AreaController {
    @Resource
    private AreaService areaService;

    @RequestMapping("getAreas.do")
    @ResponseBody
    public JsonResult getAreas() {
        List<Multiselect> area = areaService.getAreas();
        return new JsonResult(area);
    }

    @RequestMapping("getLocations.do")
    @ResponseBody
    public JsonResult getLocations() {
        List<Area> area = areaService.getLocations();
        return new JsonResult(area);
    }

    @RequestMapping("getSubLocations.do")
    @ResponseBody
    public JsonResult getSubLocations(Long areaID) {
        List<Area> subLocations = areaService.getSubLocations(areaID);
        if (subLocations != null && !subLocations.isEmpty()) {
            return new JsonResult(subLocations);
        } else {
            return new JsonResult("ok");
        }
    }

    @RequestMapping("getSuNames.do")
    @ResponseBody
    public JsonResult getSuNames() {
        List<String> list = areaService.getSuNames();
        return new JsonResult(list);
    }
}
