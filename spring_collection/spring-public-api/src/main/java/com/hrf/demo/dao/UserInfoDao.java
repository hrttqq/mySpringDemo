package com.hrf.demo.dao;

import com.hrf.demo.damain.UserInfo;

public interface UserInfoDao {

    void insertUserInfo(UserInfo userInfo);

    UserInfo queryUserInfo(String userId);
}
