package com.yaao.service.impl;

import com.yaao.dao.BindingDao;
import com.yaao.entity.User;
import com.yaao.service.BindingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 绑定账号微信号接口实现类
 *
 * @author GuTianHao
 */

@Service
public class BindingServiceImpl implements BindingService {
    @Resource
    private BindingDao bindingDao;

    /**
     * 验证账号密码
     *
     * @param logName
     * @param password
     * @param openID
     * @return
     */
    @Override
    public Map<String, Object> checkUser(String logName, String password, String openID) {
        User user = bindingDao.findUserByName(logName);
        List<String> list = bindingDao.checkOpenID(openID);
        if (user != null) {
            if (!user.getPassword().trim().equals(password.trim())) {
                user = null;
            }
        }

        Map<String, Object> map = new HashMap<>(10);
        map.put("user", user);
        map.put("list", list);
        return map;
    }

    /**
     * 绑定openID,insert至UserBindingTable
     *
     * @param openID
     * @param userID
     * @param logName
     * @param createTime
     * @param updateTime
     */
    @Override
    public void addOpenID(String openID, Integer userID, String logName, String createTime, String updateTime) {
        bindingDao.addOpenID(openID, userID, logName, createTime, updateTime);
    }

    /**
     * 检查账号是否已经被绑定
     *
     * @param logName
     * @return
     */
    @Override
    public List<String> checkLogName(String logName) {
        List<String> list = bindingDao.checkLogName(logName);
        return list;
    }
}
