package com.hrf.demo.service;

import com.hrf.demo.damain.UserInfo;

public interface UserInfoService {
    UserInfo getUserInfo();

    void insertUserInfo(UserInfo userInfo);

    UserInfo queryUserInfo(String userId);
}
