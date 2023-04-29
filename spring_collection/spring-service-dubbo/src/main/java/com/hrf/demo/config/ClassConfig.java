package com.hrf.demo.config;

import com.hrf.demo.service.UserInfoService;
import com.hrf.demo.service.UserInfoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/***
 * 作用与xml文件功能一致
 */
@Configuration
public class ClassConfig {

    /***
     * 该写法与类名上面写注解或者xml文件写bean标签功能一致
     */
    @Bean
    public UserInfoService demoService(){
        return new UserInfoServiceImpl();
    }
}
