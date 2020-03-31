package com.yaao.service;

import com.yaao.dao.AreaDao;
import com.yaao.dao.FsuDao;
import com.yaao.dao.SensorDao;
import com.yaao.dao.SoDao;
import com.yaao.entity.Area;
import com.yaao.entity.Fsu;
import com.yaao.entity.SensorFormat;
import com.yaao.entity.So;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author GuTianHao
 * 缓存服务类
 */
@Service
public class CachedService {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /**
     * 节点缓存
     */
    private Map<String, Area> areaCached = new HashMap();
    /**
     * fsu缓存
     */
    private Map<String, Fsu> fsuCached = new HashMap();
    /**
     * so缓存
     */
    private Map<String, So> soCached = new HashMap();
    /**
     * sensorFormatTable缓存
     */
    private Map<String, SensorFormat> sfCached = new HashMap();

    @Resource
    private AreaDao areaDao;

    @Resource
    private FsuDao fsuDao;

    @Resource
    private SoDao soDao;

    @Resource
    private SensorDao sensorDao;

    public void beginCached() {
        cachedArea();
        cachedFSU();
        cachedSo();
        cachedSensorFormat();
    }

    /**
     * 缓存AreaTable信息
     */
    public void cachedArea() {
        List<Area> areaList = areaDao.getAreas();
        if (areaList != null && !areaList.isEmpty()) {
            StringBuilder key = new StringBuilder();
            for (Area area : areaList) {
                key.setLength(0);
                key.append("area")
                        .append(".")
                        .append(area.getAreaID());
                areaCached.put(key.toString(), area);
            }
        }
        logger.info("缓存area，共计{}个", areaList.size());
    }

    /**
     * 缓存AreaTable信息
     */
    public void cachedFSU() {
        List<Fsu> fsuList = fsuDao.getAllFsu();
        if (fsuList != null && !fsuList.isEmpty()) {
            StringBuilder key = new StringBuilder();
            for (Fsu fsu : fsuList) {
                key.setLength(0);
                key.append("fsu")
                        .append(".")
                        .append(fsu.getFsuid());
                fsuCached.put(key.toString(), fsu);
            }
        }
        logger.info("缓存FSU，共计{}个", fsuList.size());
    }

    /**
     * 缓存SoTable信息
     */
    public void cachedSo() {
        List<So> soList = soDao.getAllSo();
        if (soList != null && !soList.isEmpty()) {
            StringBuilder key = new StringBuilder();
            for (So so : soList) {
                key.setLength(0);
                key.append("so")
                        .append(".")
                        .append(so.getFsuid())
                        .append(".")
                        .append(so.getSoCode());
                soCached.put(key.toString(), so);
            }
        }
        logger.info("缓存so，共计{}个", soList.size());
    }

    /**
     * 缓存SensorFormatTable信息
     */
    public void cachedSensorFormat() {
        List<SensorFormat> sensorFormatList = sensorDao.getAllSensor();
        if (sensorFormatList != null && !sensorFormatList.isEmpty()) {
            StringBuilder key = new StringBuilder();
            for (SensorFormat sensorFormat : sensorFormatList) {
                key.setLength(0);
                key.append("sf")
                        .append(".")
                        .append(sensorFormat.getSensorCode());
            }
        }
        logger.info("缓存sensorFormat，共计{}个", sensorFormatList.size());
    }

    /**
     * 获取area缓存对象
     *
     * @param areaID
     * @return Record
     */
    public Area getAreaCached(Long areaID) {
        StringBuilder key = new StringBuilder();
        key.append("area").append(".").append(areaID);
        Area area = areaCached.get(key.toString());
        if (area == null) {
            area = areaDao.getAreaByAreaId(areaID);
            if (area != null) {
                areaCached.put(key.toString(), area);
            }
        }
        return area;
    }

    /**
     * 更新area缓存对象
     *
     * @param areaID
     */
    public void updAreaCached(Long areaID) {
        StringBuilder key = new StringBuilder();
        key.append("area")
                .append(".")
                .append(areaID);
        Area area = areaDao.getAreaByAreaId(areaID);
        areaCached.put(key.toString(), area);
    }

    /**
     * 获取FSU缓存对象
     *
     * @param fsuID
     * @return Record
     */
    public Fsu getFSUCached(Long fsuID) {
        StringBuilder key = new StringBuilder();
        key.append("fsu").append(".").append(fsuID);
        Fsu fsu = fsuCached.get(key.toString());
        if (fsu == null) {
            fsu = fsuDao.getFsuByFsuID(fsuID);
            if (fsu != null) {
                fsuCached.put(key.toString(), fsu);
            }
        }
        return fsu;
    }

    /**
     * 更新FSU缓存对象
     *
     * @param fsuID
     */
    public void updFSUCached(Long fsuID) {
        StringBuilder key = new StringBuilder();
        key.append("fsu").append(".").append(fsuID);
        Fsu fsu = fsuDao.getFsuByFsuID(fsuID);
        fsuCached.put(key.toString(), fsu);
    }

    /**
     * 获取so缓存对象
     *
     * @param fsuID
     * @param soCode
     * @return Record
     */
    public So getSoCached(Long fsuID, Long soCode) {
        StringBuilder key = new StringBuilder();
        key.append("so").append(".").append(fsuID).append(".").append(soCode);
        So so = soCached.get(key.toString());
        if (so == null) {
            so = soDao.getSoByFsuIDAndSocode(fsuID, soCode);
            if (so != null) {
                soCached.put(key.toString(), so);
            }
        }
        return so;
    }

    /**
     * 更新so缓存对象
     *
     * @param fsuID
     * @param soCode
     */
    public void updSoCached(Long fsuID, Long soCode) {
        StringBuilder key = new StringBuilder();
        key.append("so").append(".").append(fsuID).append(".")
                .append(soCode);
        So so = soDao.getSoByFsuIDAndSocode(fsuID, soCode);
        soCached.put(key.toString(), so);
    }

    /**
     * 获取sensorFormat缓存对象
     *
     * @param sensorCode
     * @return
     */
    public SensorFormat getSensorFormatCached(String sensorCode) {
        StringBuilder key = new StringBuilder();
        key.append("sf").append(".").append(sensorCode);
        SensorFormat sf = sfCached.get(key.toString());
        if (sf == null) {
            sf = sensorDao.getSensorFormatBySensorCode(sensorCode).get(0);
            if (sf != null) {
                sfCached.put(key.toString(), sf);
            }
        }
        return sf;
    }

}
