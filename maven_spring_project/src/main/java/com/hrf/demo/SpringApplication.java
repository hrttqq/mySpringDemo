package com.hrf.demo;

import com.hrf.demo.service.TestService;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
//@ComponentScan("com.hrf.demo")
public class SpringApplication {
    public static void main( String[] args ) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring-application-context.xml");
        applicationContext.start();
        applicationContext.registerShutdownHook();
        System.in.read();

    }
}
