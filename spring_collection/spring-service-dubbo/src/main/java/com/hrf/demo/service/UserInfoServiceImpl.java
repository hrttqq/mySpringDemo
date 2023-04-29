package com.hrf.demo.service;

import com.hrf.demo.damain.UserInfo;
import com.hrf.demo.jdbc.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
//@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    public UserInfoDao userInfoDao;

    /**
     * 测试dubbo功能
     * @return
     */
    @Override
    public UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("吕小布同学");
        userInfo.setAge(10);
        return userInfo;
    }

    /**
     * 数据库写入
     * @param userInfo
     */
    @Override
    public void insertUserInfo(UserInfo userInfo) {
        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setUserName("吕小布同学");
            userInfo.setAge(10);
            userInfo.setPhone(13717032208L);
            userInfo.setUserId("20230101");
        }
        userInfoDao.insertUserInfo(userInfo);
    }

    /**
     * 查询数据库操作
     * @param userId
     * @return
     */
    @Override
    public UserInfo queryUserInfo(String userId) {
        return userInfoDao.queryUserInfo(userId);
    }
}
