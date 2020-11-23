package com.tx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@ComponentScan({"com.tx.bean","com.tx.dao.impl","com.tx.service.impl"})
@Import({DataSourceConfigure.class})
public class ApplicationContextConfig {
}
