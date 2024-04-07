package org.example.javaexample.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {
  private final Object target;

  public JDKInvocationHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("JDKInvocationHandler invoke before");
    Object result = method.invoke(target, args);
    System.out.println("JDKInvocationHandler invoke after");
    return result;
  }
}
