package com.my.anno.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

@PropertySource("classpath:jdbc.properties")
public class MySQLConfigure {
  //    @Value("${jdbc.driver}")
  //    private String driverClass;
  //
  //    @Value("${jdbc.url}")
  //    private String jdbcUrl;
  //
  //    @Value("${jdbc.username}")
  //    private String username;
  //
  //    @Value("${jdbc.pwd}")
  //    private String password;
  //
  //    @Bean("jdbcTemplate")
  //    public JdbcTemplate getJDBCTemplate() throws PropertyVetoException {
  //        JdbcTemplate jdbcTemplate = new JdbcTemplate();
  //        ComboPooledDataSource dataSource = new ComboPooledDataSource();
  //        dataSource.setDriverClass(driverClass);
  //        dataSource.setJdbcUrl(jdbcUrl);
  //        dataSource.setUser(username);
  //        dataSource.setPassword(password);
  //        jdbcTemplate.setDataSource(dataSource);
  //        return jdbcTemplate;
  //    }

  /** 为属性注解名字 */
  @Value("${jdbc.username}")
  private String username;

  @Value("${jdbc.pwd}")
  private String pwd;

  @Value("${jdbc.driver}")
  private String driver;

  @Value("${jdbc.url}")
  private String url;

  @Autowired
  @Qualifier("dataSource")
  ComboPooledDataSource dataSource;
  /**
   * 已注解的方式,设置bean对象,id = jdbcTemplate
   *
   * @return bean
   * @throws PropertyVetoException 异常
   */
  @Bean("jdbcTemplate")
  public JdbcTemplate getTemplate() throws PropertyVetoException {
    System.out.println("dataSource = " + dataSource);
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource);
    return jdbcTemplate;
  }

  @Bean("dataSource")
  public ComboPooledDataSource getDataSource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass(driver);
    dataSource.setJdbcUrl(url);
    dataSource.setUser(username);
    dataSource.setPassword(pwd);
    return dataSource;
  }
}
