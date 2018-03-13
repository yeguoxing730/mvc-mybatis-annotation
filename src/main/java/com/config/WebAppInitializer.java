package com.config;

import com.mvc.filter.CORSFilter;
import com.mvc.listener.LogListener;
import org.apache.logging.log4j.web.Log4jServletContextListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.nio.charset.StandardCharsets;

/**
 * Created by yeguoxing on 2018/3/13.
 */
public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();

        servletContext.setInitParameter("LOGDIR","d:/data/logs/mvc-mybatis-annotation");
        rootContext.register(RootConfig.class);
        // Manage the lifecycle of the root application context
        servletContext.addListener(LogListener.class);
        servletContext.addListener(Log4jServletContextListener.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));



        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", String.valueOf(StandardCharsets.UTF_8));
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");

        servletContext.addFilter("CORSFilter", CORSFilter.class).addMappingForUrlPatterns(null,false,"/*");
//        FilterRegistration.Dynamic log4jServletFilter = servletContext.addFilter("log4jServletFilter", Log4jServletFilter.class);
//        log4jServletFilter.addMappingForUrlPatterns(null, false, "/*");

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext =
                new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(MVCConfig.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
//        dispatcherContext.refresh();
    }
}
