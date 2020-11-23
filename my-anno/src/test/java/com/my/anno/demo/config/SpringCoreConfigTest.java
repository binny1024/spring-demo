package com.my.anno.demo.config;

import com.my.anno.demo.beans.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringCoreConfig.class)
public class SpringCoreConfigTest {
  @Autowired
  @Qualifier("jdbcTemplate")
  private JdbcTemplate jdbcTemplate;

  @Test
  public void mysqlJDBC() {
    List<Account> query =
        jdbcTemplate.query(
            "select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    System.out.println(query);
  }

  @Test
  public void test_c3p0_jdbc_spring_xml() throws SQLException {
    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    // 当 容器中只有一个该类的bean 时,可以使用 class 获取
    //    ComboPooledDataSource dataSource = app.getBean(ComboPooledDataSource.class);
    ComboPooledDataSource dataSource = (ComboPooledDataSource) app.getBean("comboPooledDataSource");
    Connection connection = dataSource.getConnection();
    System.out.println(connection);
    connection.close();
  }

  @Test
  public void getBean() {
    ApplicationContext app = new AnnotationConfigApplicationContext(SpringCoreConfig.class);
    JdbcTemplate j = (JdbcTemplate) app.getBean("jdbcTemplate");
    System.out.println(j);
  }

  @Autowired
  @Qualifier("dataSource")
  ComboPooledDataSource dataSource;

  @Test
  public void getConnect() throws SQLException, PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass("com.mysql.jdbc.Driver");
    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/myself");
    dataSource.setUser("root");
    dataSource.setPassword("liux1228");
    Connection connection = dataSource.getConnection();
    System.out.println(connection);
  }
}
