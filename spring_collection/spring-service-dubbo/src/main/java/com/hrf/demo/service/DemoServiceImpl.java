package com.hrf.demo.service;

import com.hrf.demo.damain.UserInfo;
import com.hrf.demo.jdbc.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Autowired
    public UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("吕小布同学");
        userInfo.setAge(10);
        return userInfo;
    }

    @Override
    public void insertUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("吕小布同学");
        userInfo.setAge(10);
        userInfo.setPhone(13717032208L);
        userInfo.setUserId("20230101");
        userInfoDao.insertUserInfo(userInfo);
    }

    @Override
    public UserInfo queryUserInfo(String userId) {
        return null;
    }
}
