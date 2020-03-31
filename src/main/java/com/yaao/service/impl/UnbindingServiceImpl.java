package com.yaao.service.impl;

import com.yaao.dao.UnbindingDao;
import com.yaao.service.UnbindingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 解绑微信号与Basic_UserTable账号接口实现类
 *
 * @author GuTianHao
 */
@Service
public class UnbindingServiceImpl implements UnbindingService {
    @Resource
    private UnbindingDao unbindingDao;

    @Override
    public void unbinding(String openID) {
        unbindingDao.unbinding(openID);
    }
}
