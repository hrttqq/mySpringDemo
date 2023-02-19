package com.hrf.demo;

import com.hrf.demo.springmvc.util.TomcatUtil;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * SpringMVC启动类
 */
public class SpirngTomcatApplication {
    private final static Logger log = LoggerFactory.getLogger(SpirngTomcatApplication.class);

    public static void main( String[] args ) {
        BasicConfigurator.configure();
        log.info("......................................Spring MVC start......................................");
        TomcatUtil.startup("SpringMvc-Demo");
        log.info("......................................Spring MVC end......................................");
    }
}
