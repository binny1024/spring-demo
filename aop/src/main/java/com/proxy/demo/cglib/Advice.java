package com.proxy.demo.cglib;

public class Advice {
  public void before() {
    System.out.println("Advice.before()....");
  }

  public void after() {
    System.out.println("Advice.after()....");
  }
}
