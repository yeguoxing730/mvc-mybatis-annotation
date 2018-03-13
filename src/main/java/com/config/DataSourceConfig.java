package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by yeguoxing on 2018/3/12.
 */
@Configuration
@PropertySource(value={"classpath:jdbc.properties"})
public class DataSourceConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Bean(name = "dataSource")
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/mysql?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        dataSource.setUser("root");
        dataSource.setPassword("Welcome1");
        dataSource.setMinPoolSize(10);
        dataSource.setAcquireIncrement(3);
        dataSource.setAcquireRetryAttempts(60);
        dataSource.setAcquireRetryDelay(1000);
        dataSource.setAutoCommitOnClose(false);
        dataSource.setCheckoutTimeout(3000);
        dataSource.setIdleConnectionTestPeriod(120);
        dataSource.setMaxIdleTime(600);
        dataSource.setTestConnectionOnCheckin(false);
        dataSource.setMaxStatements(8);
        dataSource.setMaxStatementsPerConnection(5);
        dataSource.setUnreturnedConnectionTimeout(25);
//        // create a table and populate some data
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        System.out.println("Creating tables");
//        jdbcTemplate.execute("drop table users if exists");
//        jdbcTemplate.execute("create table users(id serial, firstName varchar(255), lastName varchar(255), email varchar(255))");
//        jdbcTemplate.update("INSERT INTO users(firstName, lastName, email) values (?,?,?)", "Mike", "Lanyon", "lanyonm@gmail.com");
        return dataSource;
    }
}
