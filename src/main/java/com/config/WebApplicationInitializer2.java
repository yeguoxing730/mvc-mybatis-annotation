package com.config;

import com.mvc.filter.CORSFilter;
import com.mvc.listener.LogListener;
import org.apache.logging.log4j.web.Log4jServletContextListener;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.nio.charset.StandardCharsets;

/**
 * Created by yeguo on 2018/3/17.
 */
public class WebApplicationInitializer2 extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MVCConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("LOGDIR","d:/data/logs/mvc-mybatis-annotation");
        super.onStartup(servletContext);
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();

        servletContext.setInitParameter("LOGDIR","d:/data/logs/mvc-mybatis-annotation");
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");

        servletContext.addListener(LogListener.class);
        servletContext.addListener(Log4jServletContextListener.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));


        servletContext.addFilter("CORSFilter", CORSFilter.class).addMappingForUrlPatterns(null,false,"/*");
        AnnotationConfigWebApplicationContext dispatcherContext =
                new AnnotationConfigWebApplicationContext();

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }

}
