package com.dh.blog.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis-Plus配置
 *  开启分页功能
 *
 * @author donghao
 * @date 2019/1/3
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.dh.blog.repository")
public class MyBatisPlusConfig {

    // mybatis-plus分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
