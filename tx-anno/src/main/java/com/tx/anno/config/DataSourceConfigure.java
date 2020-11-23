package com.tx.anno.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

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

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.pwd}")
    private String password;

    /**
     * spring 会将当前方法的返回值的
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean("jdbcTemplate")
    public JdbcTemplate getDataSource() throws PropertyVetoException {
        System.out.println(toString());
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean("dataSourceTransactionManager")
    public PlatformTransactionManager getDataSourceTransactionManager() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return new DataSourceTransactionManager(dataSource);
    }

    @Override
    public String toString() {
        return "DataSourceConfigure{"
                + "driver='"
                + driver
                + '\''
                + ", url='"
                + url
                + '\''
                + ", username='"
                + username
                + '\''
                + ", password='"
                + password
                + '\''
                + '}';
    }
}
