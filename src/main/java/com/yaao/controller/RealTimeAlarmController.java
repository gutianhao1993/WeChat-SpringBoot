package com.yaao.controller;

import com.yaao.service.RealTimeAlarmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 实时告警
 *
 * @author GuTianHao
 */
@Controller
public class RealTimeAlarmController {
    @Resource
    private RealTimeAlarmService realTimeAlarmService;

    @RequestMapping("realTimeAlarm.do")
    public String realTimeAlarm() {
        return "realTimeAlarm";
    }

    @RequestMapping("getRealTimeAlarm.do")
    @ResponseBody
    public Map<String, Object> getRealTimeAlarm(String areaName, String startTime, Integer alarmLevel, String areaID
            , Integer pageCurrent, Integer pageSize) {
        Map<String, Object> map = realTimeAlarmService.getRealTimeAlarm(areaName, startTime,
                alarmLevel, areaID, pageCurrent, pageSize);
        return map;
    }
}
