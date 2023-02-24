package com.hrf.demo.service;

import com.hrf.demo.damain.UserInfo;

public interface DemoService {
    UserInfo getUserInfo();

    void insertUserInfo();

    UserInfo queryUserInfo(String userId);
}
