package com.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.jcache.JCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

/**
 * Created by yeguoxing on 2018/3/12.
 */
@Configuration
@EnableCaching
public class EhCache3Config {
    @Bean
    public CacheManager getCacheManager() throws  Exception{
        JCacheCacheManager cacheCacheManager = new JCacheCacheManager();
        cacheCacheManager.setCacheManager(getJCacheManagerFactoryBean().getObject());
        return cacheCacheManager;
    }
    @Bean
    public JCacheManagerFactoryBean getJCacheManagerFactoryBean() throws Exception{
        JCacheManagerFactoryBean jCacheManagerFactoryBean = new JCacheManagerFactoryBean();
//        PathMatchingResourcePatternResolver pathM3R = new PathMatchingResourcePatternResolver();
        URI uri = EhCache3Config.class.getClassLoader().getResource("ehcache3-config.xml").toURI();
        jCacheManagerFactoryBean.setCacheManagerUri(uri);
        return jCacheManagerFactoryBean;
    }
}
