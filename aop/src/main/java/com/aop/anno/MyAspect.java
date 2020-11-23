package com.aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 入侵代码
 */
@Component("myAspect")
@Aspect //标注当前类为一个切面类
public class MyAspect {
    private final String exec = "execution(public void com.aop.demo.Target.save())";

    @Before(value = exec)
    public void before() {
        System.out.println("MyAspect.before .......开启事务");
    }

    @After(value = exec)
    public void after() {
        System.out.println("MyAspect.after .......final");
    }

    @AfterReturning(exec)
    public void afterReturning() {
        System.out.println("MyAspect.afterReturning .....提交事务");
    }

    /**
     * 环绕:功能相当于 before和after的结合
     *
     * @param proceedingJoinPoint 正在执行的连接点
     * @return
     * @throws Throwable
     */
    @Around(value = exec)
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("MyAspect.around 0 .......");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("MyAspect.around 1 .......");
        return proceed;
    }

    /**
     * 处理异常
     */
    public void afterThrowing() {
        System.out.println("MyAspect.afterThrowing .......");
    }
}
