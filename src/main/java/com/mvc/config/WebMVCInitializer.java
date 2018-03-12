package com.mvc.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by yeguoxing on 2018/3/12.
 */
public class WebMVCInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {

//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(Config.class);
//        ctx.setServletContext(servletContext);
//
//        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
//        servlet.addMapping("/");
//        servlet.setLoadOnStartup(1);

    }
}
