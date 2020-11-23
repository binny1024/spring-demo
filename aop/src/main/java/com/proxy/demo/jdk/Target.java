package com.proxy.demo.jdk;

public class Target implements ITarget{
    public void save() {
    System.out.println("Target ......");
    }

    public void add(int a, int b) {
        System.out.println(a+b);
    }
}
