package com.uoc.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {
  /**
   * 手动测试 c3p0数据源
   *
   * @throws PropertyVetoException
   * @throws SQLException
   */
  @Test
  public void test_c3p0() throws PropertyVetoException, SQLException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass("com.mysql.jdbc.Driver");
    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/myself");
    dataSource.setUser("root");
    dataSource.setPassword("liux1228");
    Connection connection = dataSource.getConnection();
    System.out.println(connection);
    connection.close();
  }

  @Test
  public void test_c3p0_jdbc_properties() throws PropertyVetoException, SQLException {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
    String driver = resourceBundle.getString("jdbc.driver");
    String url = resourceBundle.getString("jdbc.url");
    String username = resourceBundle.getString("jdbc.username");
    String pwd = resourceBundle.getString("jdbc.pwd");
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass(driver);
    dataSource.setJdbcUrl(url);
    dataSource.setUser(username);
    dataSource.setPassword(pwd);
    Connection connection = dataSource.getConnection();
    System.out.println(connection);
    connection.close();
  }
  /**
   * 让 spring 帮我们创建 ComboPooledDataSource 对象
   *
   * @throws SQLException
   */
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
  /**
   * 测试 druid数据源
   *
   * @throws SQLException
   */
  @Test
  public void test_druid() throws SQLException {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/myself");
    dataSource.setUsername("root");
    dataSource.setPassword("liux1228");
    Connection connection = dataSource.getConnection();
    System.out.println(connection);
    connection.close();
  }
}
