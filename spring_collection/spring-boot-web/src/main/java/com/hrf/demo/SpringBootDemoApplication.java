package com.hrf.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringBootDemoApplication.class);
    public static void main(String[] args) {
        log.info("...................................Spring Boot start...................................");
        SpringApplication.run(SpringBootDemoApplication.class);
        log.info("...................................Spring Boot end...................................");
    }
}
