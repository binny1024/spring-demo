package com.aop.demo.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyCGLIBTest {

  @Test
  public void cglibProxyTest() {
    //      创建按目标对象
    final Target target = new Target();
    //    创建 advice 对象
    final Advice advice = new Advice();
    //  1,创建增强器
    Enhancer enhancer = new Enhancer();
    //  2, 设置父类
    enhancer.setSuperclass(Target.class);
    //  3,设置回调
    enhancer.setCallback(
        new MethodInterceptor() {
          public Object intercept(
              Object proxy, Method method, Object[] args, MethodProxy methodProxy)
              throws Throwable {
            advice.before();
            Object invoke = method.invoke(target, args);
            advice.after();
            return invoke;
          }
        });
    Target t = (Target) enhancer.create();
    t.save();
  }
}
