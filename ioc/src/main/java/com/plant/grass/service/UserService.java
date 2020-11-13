package com.plant.grass.service;

import com.plant.grass.bean.UserBean;

/**
 * 使用 @Service 注解将 UserService 类标识为 Spring 中的 Bean， 其写法相当于配置文件中 <bean
 * id="userService"class="com.itheima.service.UserService"/> 的书写。
 */
// @Service("userService")
public class UserService implements IUserService {

  public UserService(UserBean userBean) {
    this.userBean = userBean;
  }

  public UserService() {}

  //  @Resource(name = "userBean")
  UserBean userBean;

  public void setUserBean(UserBean userBean) {
    this.userBean = userBean;
  }

  public void save() {
    userBean.save();
  }
}
