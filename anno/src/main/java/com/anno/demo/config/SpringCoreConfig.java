package com.anno.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@Import({MySQLConfigure.class})
@ComponentScan({"com.anno.demo"})
public class SpringCoreConfig {
}
