package com.atguigu.eduservice.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：Yangrj
 * @date ：Created in 2020/4/30 16:06
 * @description：相关配置类
 * @version: $
 */
@Configuration
@MapperScan("com.atguigu.eduservice.mapper")
public class EduConfig {
    /**
     * mybatis plus分页插件
     *
     * @param
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @author Yangrj
     * @date 2020/5/17
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
