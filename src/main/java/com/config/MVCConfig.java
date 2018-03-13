package com.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.mvc.interceptor.CheckInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc
 * https://www.cnblogs.com/larryzeal/p/6160762.html
 */
@Configuration
@EnableWebMvc//<mvc:annotation-driven/>
@ComponentScan(basePackages = "com.mvc")//<context:component-scan base-package="com.mvc" />
public class MVCConfig extends WebMvcConfigurerAdapter  {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(0);
        return resolver;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //<mvc:resources mapping="/resources/**" location="/public-resources/"/>
        registry.addResourceHandler("/view/**").addResourceLocations("/view/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //TODO Auto-generated method stub
        super.addInterceptors(registry);
        registry.addInterceptor(new CheckInterceptor());
//      registry.addInterceptor(new ThemeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
//      registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");
    }

    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        // TODO Auto-generated method stub
        super.addArgumentResolvers(argumentResolvers);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // TODO Auto-generated method stub
        super.addFormatters(registry);
    }

    @Override
    public void addReturnValueHandlers(
            List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        // TODO Auto-generated method stub
        super.addReturnValueHandlers(returnValueHandlers);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // TODO Auto-generated method stub
        super.addViewControllers(registry);
    }


    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        // TODO Auto-generated method stub
        super.configureMessageConverters(converters);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // TODO Auto-generated method stub
        super.extendMessageConverters(converters);
        FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter4 = new FastJsonHttpMessageConverter4();
        ArrayList<MediaType> supportedMediaTypes =  new ArrayList<>();
        supportedMediaTypes.add(MediaType.valueOf("application/json;charset=UTF-8"));
        fastJsonHttpMessageConverter4.setSupportedMediaTypes(supportedMediaTypes);
        converters.add(fastJsonHttpMessageConverter4);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        ArrayList<MediaType> stringSupportedMediaTypes =  new ArrayList<>();
        stringSupportedMediaTypes.add(MediaType.valueOf("text/html;charset=utf-8"));
        converters.add(stringHttpMessageConverter);
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        // TODO Auto-generated method stub
        super.configureAsyncSupport(configurer);
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        // TODO Auto-generated method stub
        super.configureContentNegotiation(configurer);
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        // TODO Auto-generated method stub
        super.configureDefaultServletHandling(configurer);
        // 开启默认转发
        configurer.enable();// <mvc:default-servlet-handler/>
    }

    @Override
    public void configureHandlerExceptionResolvers(
            List<HandlerExceptionResolver> exceptionResolvers) {
        // TODO Auto-generated method stub
        super.configureHandlerExceptionResolvers(exceptionResolvers);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // TODO Auto-generated method stub
        super.configurePathMatch(configurer);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // TODO Auto-generated method stub
        super.configureViewResolvers(registry);
    }
}