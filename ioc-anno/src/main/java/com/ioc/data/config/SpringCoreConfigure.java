package com.ioc.data.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/** Spring 容器的核心配置类 */
@Configuration
@ComponentScan("com.ioc.data")
@Import({DataSourceConfigure.class})//导入相关的注解类
public class SpringCoreConfigure {}
