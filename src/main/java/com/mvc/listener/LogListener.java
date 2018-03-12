package com.mvc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * set system log file location
 */
public class LogListener implements ServletContextListener {
    public static final String log4jdirkey = "LOGDIR";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String log4jdir = sce.getServletContext().getInitParameter(log4jdirkey);
        System.setProperty(log4jdirkey, log4jdir);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.getProperties().remove(log4jdirkey);
    }
}
