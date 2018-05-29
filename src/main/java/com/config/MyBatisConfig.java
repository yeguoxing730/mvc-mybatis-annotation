package com.config;

import com.mvc.dbinterceptor.SqlInterceptor;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableTransactionManagement
@MapperScan("com.mvc.dao")
@Import(DataSourceConfig.class)
public class MyBatisConfig {
    @Resource(name="dataSource")
    public DataSource dataSource;

    @Bean
    public DataSourceTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver pathM3R = new PathMatchingResourcePatternResolver();
        sessionFactory.setConfigLocation(pathM3R.getResource("mybatis-config.xml"));
        sessionFactory.setPlugins(new Interceptor[]{new SqlInterceptor()} );
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
