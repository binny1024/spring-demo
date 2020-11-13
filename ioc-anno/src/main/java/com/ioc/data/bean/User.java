package com.ioc.data.bean;

import org.springframework.stereotype.Repository;

/**
 * <bean id="userBean" class="com.ioc.data.bean.User"/>
 * */
@Repository("userBean")
public class User implements IUser {
  public void save() {
    System.out.println("User.save() ......");
  }
}
