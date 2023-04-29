package com.hrf.demo.springmvc.controller;

import com.hrf.demo.damain.UserInfo;
import com.hrf.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *
 */
@RestController
@RequestMapping("/SpringMvc")
public class SpringMvcDemoRest {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/status")
    public String demoTest(){
        return "status";
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserInfo getUserInfo(){
        UserInfo userInfo = userInfoService.getUserInfo();
        return userInfo;
    }

    @RequestMapping(path = "/queryUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public UserInfo queryUserInfo(@RequestParam(name = "userId") String userId){
        UserInfo userInfo = userInfoService.queryUserInfo(userId);
        return userInfo;
    }

    @RequestMapping(path = "/insertUserInfo",method = RequestMethod.POST)
    public void insertUserInfo(@RequestBody UserInfo userInfo){
        userInfoService.insertUserInfo(userInfo);
    }
}
