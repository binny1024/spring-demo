package com.aop.anno;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements ITarget {
  public void save() {
    int i = 1 / 0;
    System.out.println("Target ......");
  }
}
