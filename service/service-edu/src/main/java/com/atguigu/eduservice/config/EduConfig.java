package com.atguigu.eduservice.config;

import org.mybatis.spring.annotation.MapperScan;
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
}
