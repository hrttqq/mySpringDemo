package com.hrf.demo.springmvc.util;

import com.hrf.demo.springmvc.config.InitConfig;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Tomcat工具类
 */
public class TomcatUtil {
    private final static Logger log = LoggerFactory.getLogger(TomcatUtil.class);


    public TomcatUtil(){
    }

    public static void startup(String appName){
        Tomcat tomcat = null;
        try {
            tomcat = new Tomcat();
            File baseDir = new File(System.getProperty("java.io.tmpdir"), appName);
            tomcat.setBaseDir(baseDir.getAbsolutePath());
            tomcat.setPort(InitConfig.MAIN_PORT);
            tomcat.getConnector().setProperty("maxThreads", InitConfig.TOMCAT_MAX_THREADS);
            tomcat.getConnector().setProperty("minSpareThreads",InitConfig.TOMCAT_MIN_SPARE_THREADS);
            tomcat.getConnector().setProperty("maxConnections",InitConfig.TOMCAT_MAX_CONNECTIONS);
            tomcat.getConnector().setProperty("acceptCount",InitConfig.TOMCAT_ACCEPT_COUNT);
            tomcat.getConnector().setProperty("URIEncoding","UTF-8");
            tomcat.getConnector().setProperty("connectionsTimeout",InitConfig.TOMCAT_CONNECTIONS_TIMEOUT);
            tomcat.getConnector().setProperty("enableLookups","false");
            tomcat.getConnector().setProperty("keepaliveTimeout",InitConfig.TOMCAT_KEEPALIVE_TIMEOUT);
            tomcat.getConnector().setProperty("maxKeepAliveRequests",InitConfig.TOMCAT_MAX_KEEP_ALIVE_REQIESTS);

            File webappPath = new File(InitConfig.MAIN_DIR, "webapp");
            if (!webappPath.exists()){
                webappPath = new File(InitConfig.MAIN_DIR,"src/main/webapp");
            }
            if (InitConfig.MAIN_DIR != null && !"".equals(InitConfig.MAIN_DIR.trim())){
                System.getProperty("catalina.base",InitConfig.MAIN_DIR);
            }

            StandardContext ctx = (StandardContext) tomcat.addWebapp("", webappPath.getCanonicalPath());

            File additionWebInfClasses = new File("target/classes");
            if (additionWebInfClasses.exists()){
                WebResourceRoot resources = new StandardRoot(ctx);
                resources.addPreResources(new DirResourceSet(resources,"/WEB-INF/classes",additionWebInfClasses.getAbsolutePath(),"/"));
                ctx.setResources(resources);
            }
            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (tomcat != null){
                try {
                    tomcat.stop();
                } catch (LifecycleException e) {

                }
            }
        }
    }
}
