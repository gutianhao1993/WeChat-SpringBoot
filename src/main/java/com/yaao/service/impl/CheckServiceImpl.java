package com.yaao.service.impl;

import com.yaao.dao.CheckInfoDao;
import com.yaao.service.CheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 检查账号与微信号是否满足绑定条件接口实现类
 *
 * @author GuTianHao
 */
@Service
public class CheckServiceImpl implements CheckService {
    @Resource
    private CheckInfoDao checkInfoDao;

    /**
     * 查询openID是否已经绑定
     *
     * @param openID
     * @return
     */
    @Override
    public List<String> checkInfo(String openID) {
        List<String> list = checkInfoDao.checkInfo(openID);

        if (list != null && !list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }
}
