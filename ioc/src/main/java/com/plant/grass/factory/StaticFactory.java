package com.plant.grass.factory;

import com.plant.grass.bean.UserBean;

public class StaticFactory {
  public static UserBean getUserBean() {
    System.out.println("静态工厂.....");
    return new UserBean();
  }
}
