package com.anno.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

@PropertySource("classpath:jdbc.properties")
public class MySQLConfigure {
        @Value("${jdbc.driver}")
        private String driverClass;

        @Value("${jdbc.url}")
        private String jdbcUrl;

        @Value("${jdbc.username}")
        private String username;

        @Value("${jdbc.pwd}")
        private String password;

        @Bean("jdbcTemplate")
        public JdbcTemplate getJDBCTemplate() throws PropertyVetoException {
            JdbcTemplate jdbcTemplate = new JdbcTemplate();
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driverClass);
            dataSource.setJdbcUrl(jdbcUrl);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            jdbcTemplate.setDataSource(dataSource);
            return jdbcTemplate;
        }
}
