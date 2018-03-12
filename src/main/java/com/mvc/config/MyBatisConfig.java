package com.mvc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@MapperScan("com.mvc.dao")
public class MyBatisConfig {
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver.class");
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

    @Bean
    public DataSourceTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        PathMatchingResourcePatternResolver pathM3R = new PathMatchingResourcePatternResolver();
        sessionFactory.setConfigLocation(pathM3R.getResource("mybatis-config.xml"));
        return sessionFactory;
    }
    @Bean
    public org.apache.ibatis.session.Configuration  mybatisConfig() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(StdOutImpl.class);
        configuration.setCacheEnabled(true);
        configuration.setLazyLoadingEnabled(true);
        configuration.setAggressiveLazyLoading(false);
        configuration.setMultipleResultSetsEnabled(true);
        configuration.setUseColumnLabel(true);
        configuration.setUseGeneratedKeys(false);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.PARTIAL);
        configuration.setDefaultExecutorType(ExecutorType.SIMPLE);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLocalCacheScope(LocalCacheScope.SESSION);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setDefaultStatementTimeout(180);

//        configuration.getTypeAliasRegistry().registerAlias("Page", Page.class);

////      PageHelper pager = new PageHelper();
//        PageInterceptor pageInterceptor = new PageInterceptor();
//
//        Properties p = new Properties();
//        p.put("helperDialect", "mysql");
//        p.put("offsetAsPageNum", "true");
//        p.put("rowBoundsWithCount", "true");
//        p.put("pageSizeZero", "true");
//        p.put("reasonable", "true");
//
//        pageInterceptor.setProperties(p);
//        configuration.addInterceptor(pageInterceptor);

        return configuration;

    }
}
