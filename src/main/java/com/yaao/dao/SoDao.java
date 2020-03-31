package com.yaao.dao;

import com.yaao.entity.So;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SoTable
 *
 * @author GuTianHao
 */
public interface SoDao {
    /**
     * 获取所有So对象
     *
     * @return
     */
    List<So> getAllSo();

    /**
     * 根据fsuID和socode获取So对象
     *
     * @param fsuID
     * @param soCode
     * @return
     */
    So getSoByFsuIDAndSocode(@Param("fsuID") Long fsuID, @Param("soCode") Long soCode);
}
