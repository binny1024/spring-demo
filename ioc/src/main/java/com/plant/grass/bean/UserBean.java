package com.plant.grass.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 使用 @Repository 注解将 UserBean 类标识为 Spring 中的 Bean 其写法相当于配置文件中 <bean
 * id="userBean"class="com.itheima.bean.UserBean"/> 的书写
 */
// @Repository("userBean")
public class UserBean implements IUserBean {

  private String name = "default";
  private int age;

  private List<String> strings;
  private Map<String, Book> bookMap;
  private Properties properties;

  public void setStrings(List<String> strings) {
    this.strings = strings;
  }

  public void setBookMap(Map<String, Book> bookMap) {
    this.bookMap = bookMap;
  }

  public void setProperties(Properties properties) {
    this.properties = properties;
  }

  public UserBean() {
    System.out.println("UserDao 创建......");
  }

  public void save() {
    System.out.println(this.toString());
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "UserBean{"
        + '\n'
        + "name='"
        + name
        + '\n'
        + ", age="
        + age
        + '\n'
        + ", strings="
        + strings
        + '\n'
        + ", bookMap="
        + bookMap
        + '\n'
        + ", properties="
        + properties
        + '}';
  }
}
