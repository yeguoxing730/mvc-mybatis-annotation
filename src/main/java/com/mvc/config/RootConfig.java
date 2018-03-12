package com.mvc.config;

import com.mvc.dao.StudentMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yeguoxing on 2018/3/12.
 */
@Configuration
@ComponentScan(basePackages = "com.mvc.service")
@Import({ MyBatisConfig.class })
public class RootConfig {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
       ctx.register(RootConfig.class);
       ctx.refresh();
       StudentMapper studentMapper = ctx.getBean(StudentMapper.class);
       System.out.println(studentMapper.selectByPrimaryKey(1));
    }
}
