package com.uoc.data;

import com.ioc.data.config.SpringCoreConfigure;
import com.ioc.data.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 加载配置文件
//@ContextConfiguration("classpath:applicationContext.xml")
//加载注解
@ContextConfiguration(classes={SpringCoreConfigure.class})
public class SpringJUnitTest {
  @Autowired private UserService userService;
  @Test
  public void test() {
    userService.save();
  }
}
