package com.proxy.demo.jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyJDKTest {

    @Test
    public void jdkProxyTest() {
        //    创建按目标对象，被代理的对象
        final Target target = new Target();
        //    创建 advice 对象，新增的逻辑
        final Advice advice = new Advice();
        //    创建代理类
        ITarget iTarget =
                (ITarget)
                        Proxy.newProxyInstance(
                                target.getClass().getClassLoader(),
                                target.getClass().getInterfaces(),
                                new InvocationHandler() {
                                    public Object invoke(Object proxy, Method method, Object[] args)
                                            throws Throwable {
                                        System.out.println("代理方法");
                                        advice.before(); // 新增的
                                        Object invoke = method.invoke(target, args); // 目标方法
                                        advice.after(); // 新增的
                                        return invoke;
                                    }
                                });
        //    这个时候执行 save方法时,会执行invoke中的代码
        System.out.println("11111111111111");
        iTarget.save();
        System.out.println("222222222222222");
        iTarget.add(3,4);
    }
}
