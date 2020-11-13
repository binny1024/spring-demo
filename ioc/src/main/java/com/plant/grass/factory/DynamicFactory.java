package com.plant.grass.factory;

import com.plant.grass.bean.UserBean;

public class DynamicFactory {
  public UserBean getUserBean() {
    System.out.println("动态工厂.....");
    return new UserBean();
  }
}
