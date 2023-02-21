package com.hrf.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


/**
 * Spring整合dubbo启动类
 */
public class SpringDubboApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringDubboApplication.class);

    public static void main(String[] args) throws Exception {
        logger.info("......................................Spring start......................................");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-application.xml");
        context.start();
        context.registerShutdownHook();
        logger.info("......................................Spring end......................................");
        synchronized (SpringDubboApplication.class) {
            SpringDubboApplication.class.wait();
        }
    }
}
