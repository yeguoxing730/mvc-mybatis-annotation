package com.mvc.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yeguoxing on 2018/3/12.
 */
@Configuration
@ComponentScan(basePackages = "com.mvc.dao,com.mvc.service")
@Import({ MyBatisConfig.class })
public class RootConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.register(RootConfig.class);
        ctx.refresh();
//        MyService myService = ctx.getBean(MyService.class);
//        myService.doStuff();
    }
}
