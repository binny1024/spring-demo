package com.jdbc.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

// 设置使用的属性文件
@PropertySource("classpath:jdbc.properties")
public class MysqlDataSource {

    /** 为属性注解名字 */
    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.pwd}")
    private String pwd;

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    /**
     * 已注解的方式,设置bean对象,id = jdbcTemplate
     *
     * @return bean
     * @throws PropertyVetoException 异常
     */
    @Bean("jdbcTemplate")
    public JdbcTemplate getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(pwd);
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
