package com.yaao.dao;

import com.yaao.entity.Fsu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * FsuTable
 *
 * @author GuTianHao
 */
public interface FsuDao {
    /**
     * 获取所有Fsu对象
     *
     * @return
     */
    List<Fsu> getAllFsu();

    /**
     * 根据fsuID获取Fsu对象
     *
     * @param fsuID
     * @return
     */
    Fsu getFsuByFsuID(@Param("fsuID") Long fsuID);
}
