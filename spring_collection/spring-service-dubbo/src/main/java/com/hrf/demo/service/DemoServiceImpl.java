package com.hrf.demo.service;

import com.hrf.demo.damain.UserInfo;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Override
    public UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("吕小布同学");
        userInfo.setAge(10);
        return userInfo;
    }
}
