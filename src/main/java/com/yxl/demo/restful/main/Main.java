package com.yxl.demo.restful.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 程序主入口
 * author: xiaolong.yuanxl
 * date: 2015-5-1
 */
public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            String[] files = {"spring-dataSource.xml", "spring-manager.xml", "spring-web.xml"};
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext(files);
            Launcher launcher = (Launcher) applicationContext.getBean("launcher");
            launcher.start();
        } catch (Exception e) {
            LOG.error("start error " + e.getMessage(), e);
            System.exit(1);
        }
    }
}