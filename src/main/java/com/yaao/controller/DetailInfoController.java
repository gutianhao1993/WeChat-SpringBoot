package com.yaao.controller;

import com.yaao.service.DetailInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 详细信息
 *
 * @author GuTianHao
 */
@Controller
public class DetailInfoController {
    @Resource
    private DetailInfoService detailInfoService;

    @RequestMapping("detailInfo.do")
    public String detailInfo() {
        return "detailInfo";
    }

    @RequestMapping("getDetailInfo.do")
    @ResponseBody
    public Map getDetailInfo(Integer id) {
        Map<String, Object> map = detailInfoService.getDetailInfo(id);
        return map;
    }

    @RequestMapping("getAlarmDetailInfo.do")
    @ResponseBody
    public Map getAlarmDetailInfo(Long alarmID) {
        Map<String, Object> map = detailInfoService.getAlarmlDetailInfo(alarmID);
        return map;
    }
}
