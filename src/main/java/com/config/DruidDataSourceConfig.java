package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by yeguoxing on 2018/3/12.
 */
@Configuration
@PropertySource(value={"classpath:jdbc.properties"})
public class DruidDataSourceConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Bean("readerDataSource")
    public DataSource readDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mysql?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("Welcome1");
        return druidDataSource;
    }
}
