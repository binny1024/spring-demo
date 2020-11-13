package com.aop.demo.jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyJDKTest {

  @Test
  public void jdkProxyTest() {
    //      创建按目标对象
    final Target target = new Target();
    //    创建 advice 对象
    final Advice advice = new Advice();
    ITarget iTarget =
        (ITarget)
            Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                  public Object invoke(Object proxy, Method method, Object[] args)
                      throws Throwable {
                    advice.before(); // 新增的
                    Object invoke = method.invoke(target, args); // 目标方法
                    advice.after(); // 新增的
                    return invoke;
                  }
                });
    //    这个时候执行 save方法时,会执行invoke中的代码
    iTarget.save();
  }
}
