package com.aop.demo;

public class Target implements ITarget {
  public void save() {
    int i = 1 / 0;
    System.out.println("Target ......");
  }
}
