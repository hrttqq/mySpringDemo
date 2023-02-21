package com.hrf.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class SpringJdbcApplication {
    private static Logger log = LoggerFactory.getLogger(SpringJdbcApplication.class);

    public static void main(String[] args) throws Exception {
        log.info("......................................Spring start......................................");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-application.xml");
        context.start();
        context.registerShutdownHook();
        log.info("......................................Spring end......................................");
        synchronized (SpringJdbcApplication.class) {
            SpringJdbcApplication.class.wait();
        }

    }

}
