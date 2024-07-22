package com.hrf.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class TestService{

    @Autowired
    private UserService userService;

    public void test() {
        System.out.println(userService);
    }
}
