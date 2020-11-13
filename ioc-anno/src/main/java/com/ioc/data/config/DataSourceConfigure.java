package com.ioc.data.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyVetoException;

/**
 * Configuration 标志该类可以用来替换xml文件
 *
 * <p><context:component-scan base-package="com.ioc.data"/>
 */
// <context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfigure {
    @Value("${jdbc.driver}")
    private String driver;
    /**
     * spring 会将当前方法的返回值的
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean("comboPooledDataSource")
    public ComboPooledDataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl("${jdbc.url}");
        dataSource.setUser("${jdbc.username}");
        dataSource.setPassword("${jdbc.pwd}");
        return dataSource;
    }
}
