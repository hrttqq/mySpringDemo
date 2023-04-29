package com.hrf.demo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SpringBootWeb")
public class SpringBootWebController {
    private static final Logger log = LoggerFactory.getLogger(SpringBootWebController.class);

    @RequestMapping(path = "/status")
    public String status(){
        log.info("status!");
        return "springboot success!";
    }
}
