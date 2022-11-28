package com.hrf.demo.service.impl;

import com.hrf.demo.service.TestService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println("hello word!!!");
    }
}
