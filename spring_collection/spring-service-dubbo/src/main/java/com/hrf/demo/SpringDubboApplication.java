package com.hrf.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class SpringDubboApplication {
    public static void main( String[] args ) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-application.xml");
        context.start();
        context.registerShutdownHook();
        System.in.read();
    }
}
