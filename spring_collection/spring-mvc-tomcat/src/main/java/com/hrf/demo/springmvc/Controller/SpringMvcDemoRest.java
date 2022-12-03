package com.hrf.demo.springmvc.Controller;

import com.hrf.demo.damain.UserInfo;
import com.hrf.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 */
@RestController
@RequestMapping("/SpringMvcTest")
public class SpringMvcDemoRest {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/demoTest")
    public String demoTest(){
        return "Test";
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserInfo getUserInfo(){
        UserInfo userInfo = demoService.getUserInfo();
        return userInfo;
    }
}
