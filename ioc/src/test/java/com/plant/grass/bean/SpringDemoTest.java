package com.plant.grass.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoTest {
  /**
   * 通过 spring 获取 javabean <bean id="UserDao" class="com.itheima.dao.UserDao"></bean> id：bean的唯一的表示
   * class：类的全路径限定名 ;scope:singleton 即默认情况下单例模式 单例模式下,bean的创建在app.getBean("id")之前就已经创建了
   */
  @Test
  public void bean() {
    ClassPathXmlApplicationContext app =
        new ClassPathXmlApplicationContext("applicationContext.xml");
    UserBean userBean = (UserBean) app.getBean("UserBean");
    userBean.save();
    //    userBean = (UserDao) app.getBean("UserBean");
    //    userBean.save();
    app.close();
  }

  /**
   * <bean id="UserDaoMany" class="com.itheima.dao.UserDao" scope="prototype"></bean>
   * scope:prototype 多例模式创建实体类 多例模式下,什么时候使用,什么时候创建
   */
  @Test
  public void beans() {
    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserBean userBean = (UserBean) app.getBean("UserDaoMany");
    userBean.save();
    userBean = (UserBean) app.getBean("UserDaoMany");
    userBean.save();
  }

  @Test
  public void staticFactory() {
    ClassPathXmlApplicationContext app =
        new ClassPathXmlApplicationContext("applicationContext.xml");
    UserBean userBean = (UserBean) app.getBean("UserBean");
    userBean.save();
    //    userBean = (UserDao) app.getBean("UserBean");
    //    userBean.save();
    app.close();
  }

  @Test
  public void dynamicFactory() {
    ClassPathXmlApplicationContext app =
        new ClassPathXmlApplicationContext("applicationContext.xml");
    UserBean userBean = (UserBean) app.getBean("UserBean");
    userBean.save();
    //    userBean = (UserDao) app.getBean("UserBean");
    //    userBean.save();
    app.close();
  }
}
