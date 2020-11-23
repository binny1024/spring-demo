package com.jdbc.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 自定义 spring 核心配置类
@Configuration
// 设置扫描的包及其子包下的类
@ComponentScan("com.jdbc.demo")
// 导入注解类
@Import({MysqlDataSource.class}) // 导入相关的注解类
public class SpringCoreConfigure {}
