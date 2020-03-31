package com.yaao.service.impl;

import com.yaao.dao.DetailInfoDao;
import com.yaao.entity.Alarm;
import com.yaao.service.CachedService;
import com.yaao.service.DetailInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * 告警详情接口实现类
 *
 * @author GuTianHao
 */
@Service
public class DetailInfoServiceImpl implements DetailInfoService {
    @Resource
    private DetailInfoDao detailInfoDao;

    @Resource
    private CachedService cachedService;

    /**
     * 实时推送告警详情页面
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getDetailInfo(Integer id) {
        Map<String, Object> map = new HashMap<>(10);

        Alarm alarm = detailInfoDao.getDetailInfo(id);
        if (alarm != null) {
            //获取SensorName
            Long sensorCode = alarm.getSensorCode();
            StringBuilder str = new StringBuilder(sensorCode.toString());
            sensorCode = Long.parseLong(str.replace(str.length() - 3, str.length(), "000").toString());
            String sensorName = cachedService.getSensorFormatCached(sensorCode.toString()).getSensorName();

            //获取FsuName
            Long fsuID = alarm.getFsuid();
            String fsuName = cachedService.getFSUCached(fsuID).getFsuName();

            //获取SoName
            Long soCode = alarm.getSoCode();
            String soName = cachedService.getSoCached(fsuID, soCode).getSoName();

            String AlarmTime = alarm.getAlarmTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                alarm.setAlarmTime(sdf.format(sdf.parse(AlarmTime)));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            alarm.setSoName(soName);
            alarm.setFsuName(fsuName);
            alarm.setSensorName(sensorName);

            map.put("alarm", alarm);
            return map;
        } else {
            return null;
        }

    }

    /**
     * 活动告警详情页面
     *
     * @param alarmID
     * @return
     */
    @Override
    public Map<String, Object> getAlarmlDetailInfo(Long alarmID) {
        Map<String, Object> map = new HashMap<>(10);
        Alarm alarm = detailInfoDao.getAlarmDetailInfo(alarmID);
        if (alarm != null) {
            //获取SensorName
            Long sensorCode = alarm.getSensorCode();
            StringBuilder str = new StringBuilder(sensorCode.toString());
            sensorCode = Long.parseLong(str.replace(str.length() - 3, str.length(), "000").toString());
            String sensorName = cachedService.getSensorFormatCached(sensorCode.toString()).getSensorName();

            String StartTime = alarm.getStartTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                alarm.setStartTime(sdf.format(sdf.parse(StartTime)));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //获取FsuName
            Long fsuID = alarm.getFsuid();
            String fsuName = cachedService.getFSUCached(fsuID).getFsuName();

            //获取SoName
            Long soCode = alarm.getSoCode();
            String soName = cachedService.getSoCached(fsuID, soCode).getSoName();

            //获取ParentPath
            String ParentPath = cachedService.getSoCached(fsuID, soCode).getParentPath();

            //获取AreaName
            Long areaID = cachedService.getSoCached(fsuID, soCode).getAreaId();

            StringBuilder AreaNames = new StringBuilder(cachedService.getAreaCached(areaID).getAreaName());
            String AreaName = "";
            String system = "1";
            if (ParentPath != null && !system.equals(ParentPath)) {
                String[] parentIDs = ParentPath.split(",");
                for (int i = parentIDs.length - 2; i >= 0; i--) {
                    AreaName = cachedService.getAreaCached(Long.parseLong(parentIDs[i])).getAreaName();
                    AreaNames.insert(0, AreaName + "_");
                }
            }

            alarm.setAreaName(AreaNames.toString());
            alarm.setSensorName(sensorName);
            alarm.setFsuName(fsuName);
            alarm.setSoName(soName);

            map.put("alarm", alarm);
            return map;
        } else {
            return null;
        }
    }
}
