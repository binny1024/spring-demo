package com.uoc.data;

import com.ioc.data.config.SpringCoreConfigure;
import com.ioc.data.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTest {
  @Test
  public void annotationTest() {
    //    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    //    使用核心配置类
    ApplicationContext app = new AnnotationConfigApplicationContext(SpringCoreConfigure.class);
    UserService userService = (UserService) app.getBean("userService");
    userService.save();
  }
}
