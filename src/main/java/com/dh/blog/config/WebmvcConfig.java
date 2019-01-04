package com.dh.blog.config;

import com.dh.blog.filter.LoginStatusFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebmvcConfig implements WebMvcConfigurer {

    // 罗列所有不需登录就能访问的路径uri
    @Value("${blog.uriList}")
    private List<String> uriList;

    // 添加针对swagger的处理，避免swagger404
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

    // 添加登录拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginStatusFilter())
                .addPathPatterns("/*")
                .excludePathPatterns(uriList);
    }
}