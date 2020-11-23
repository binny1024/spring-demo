package com.tx.anno.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com.tx.anno"})
@Import({DataSourceConfigure.class})
@EnableTransactionManagement
@Configuration
public class ApplicationContextConfig {
}
