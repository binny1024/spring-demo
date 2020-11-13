package com.plant.grass.service;

import com.plant.grass.bean.Book;
import com.plant.grass.bean.UserBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class applicationContextTest {
  /** 获取一个用户实例 */
  @Test
  public void userBean() {
    ClassPathXmlApplicationContext app =
        new ClassPathXmlApplicationContext("applicationContext-User.xml");
    UserBean userService = (UserBean) app.getBean("userBean");
    userService.save();
  }

  @Test
  public void userBeanByStaticFactory() {
    ClassPathXmlApplicationContext app =
            new ClassPathXmlApplicationContext("applicationContext-User.xml");
    UserBean userService = (UserBean) app.getBean("userBean2");
    userService.save();
  }
  /** */ 
  @Test
  public void userBeanByDynamicFactory() {
    ClassPathXmlApplicationContext app =
            new ClassPathXmlApplicationContext("applicationContext-User.xml");
    UserBean userService = (UserBean) app.getBean("userBean3");
    userService.save();
  }
  /** 测试书籍实例
   *  */
  @Test
  public void book() {
    ClassPathXmlApplicationContext app =
        new ClassPathXmlApplicationContext("applicationContext-Book.xml");
    Book book = (Book) app.getBean("book0");
    book.save();
    book = (Book) app.getBean("book1");
    book.save();
    book = (Book) app.getBean("book2");
    book.save();
    book = (Book) app.getBean("book3");
    book.save();
  }

  /** */
  @Test
  public void testDISet() {
    ClassPathXmlApplicationContext app =
        new ClassPathXmlApplicationContext("applicationContext-Service.xml");
    UserService userService = (UserService) app.getBean("userService");
    userService.save();
  }
}
