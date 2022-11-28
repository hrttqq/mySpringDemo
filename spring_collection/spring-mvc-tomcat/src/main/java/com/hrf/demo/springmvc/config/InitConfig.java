package com.hrf.demo.springmvc.config;

public class InitConfig {
    //加载的端口号
    public static int MAIN_PORT = 5123;
    //应用配置
    public static String MAIN_DIR = "spring-mvc-tomcat";
    public static String TOMCAT_MAX_THREADS = "200";
    public static String TOMCAT_MIN_SPARE_THREADS = "20";
    public static String TOMCAT_MAX_CONNECTIONS = "10000";
    public static String TOMCAT_CONNECTIONS_TIMEOUT = "20000";
    public static String TOMCAT_KEEPALIVE_TIMEOUT = "60000";
    public static String TOMCAT_MAX_KEEP_ALIVE_REQIESTS = "100";
    public static String TOMCAT_ACCEPT_COUNT = "100";
}
