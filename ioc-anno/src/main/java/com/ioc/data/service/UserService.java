package com.ioc.data.service;

import com.ioc.data.bean.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/** <bean id="userService" class="com.ioc.data.service.UserService"></bean> */
@Service("userService")
public class UserService implements IUserService {

  //  <property name="user"  ref="userBean"/>

  /** Bean 的实例名称由 @Qualifier 注解的参数指定 */
  @Autowired
  @Qualifier("userBean")
  private IUser user;

  @Value("${jdbc.driver}")
  private String name;
  public void save() {
    System.out.println(name);
    user.save();
  }
  @PostConstruct
  public void init(){
    System.out.println("init .....");
  }
  @PreDestroy
  public void destroy(){
    System.out.println("destroy .....");
  }
}
