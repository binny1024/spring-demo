package com.aop.demo;

import org.aspectj.lang.ProceedingJoinPoint;

/** 切面类 */
public class MyAspect {
  public void before() {
    System.out.println("MyAspect.before .......");
  }

  public void after() {
    System.out.println("MyAspect.after .......");
  }
  public void afterReturning() {
    System.out.println("MyAspect.afterReturning .......");
  }
  /**
   * 环绕:功能相当于 before和after的结合
   *
   * @param proceedingJoinPoint 正在执行的连接点
   * @return
   * @throws Throwable
   */
  public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out.println("MyAspect.around 0 .......");
    Object proceed = proceedingJoinPoint.proceed();
    System.out.println("MyAspect.around 1 .......");
    return proceed;
  }
  /** 处理异常 */
  public void afterThrowing() {
    System.out.println("MyAspect.afterThrowing .......");
  }
}
