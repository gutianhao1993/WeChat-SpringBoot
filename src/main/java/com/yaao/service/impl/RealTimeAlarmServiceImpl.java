package com.yaao.service.impl;

import com.yaao.dao.RealTimeAlarmDao;
import com.yaao.entity.RealTimeAlarm;
import com.yaao.service.RealTimeAlarmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 实时告警接口实现类
 *
 * @author GuTianHao
 */
@Service
public class RealTimeAlarmServiceImpl implements RealTimeAlarmService {
    @Resource
    private RealTimeAlarmDao realTimeAlarmDao;

    @Override
    public Map<String, Object> getRealTimeAlarm(String areaName, String startTime, Integer alarmLevel, String areaID
            , Integer pageCurrent, Integer pageSize) {

        //分页
        int startIndex = (pageCurrent - 1) * pageSize;
        int rowCount = realTimeAlarmDao.getRowCount(areaName, startTime, alarmLevel, areaID);
        int pageCount = rowCount / pageSize;
        if (rowCount % pageSize != 0) {
            pageCount++;
        }

        List<RealTimeAlarm> list = realTimeAlarmDao.getRealTimeAlarm(areaName, startTime, alarmLevel,
                areaID, startIndex, pageSize);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<String> alarmID = new ArrayList<>();
        List<String> soCode = new ArrayList<>();
        try {
            for (int i = 0; i < list.size(); i++) {
                //Long型在后台需要先转为String,否则传到前台会发生数据偏差
                alarmID.add(list.get(i).getAlarmID().toString());
                soCode.add(list.get(i).getSoCode().toString());
                //时间格式转换
                list.get(i).setStartTime(sdf.format(sdf.parse(list.get(i).getStartTime())));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<>(10);
        map.put("list", list);
        map.put("pageSize", pageSize);
        map.put("pageCurrent", pageCurrent);
        map.put("startIndex", startIndex);
        map.put("rowCount", rowCount);
        map.put("pageCount", pageCount);
        map.put("alarmID", alarmID);
        map.put("soCode", soCode);
        return map;
    }
}
