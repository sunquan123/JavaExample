package org.example.JavaGuide.proxy;

import java.lang.reflect.Proxy;

public class JDKInvocationHandlerFactory {
  public static Object getProxy(Object target) {
    return Proxy.newProxyInstance(
        target.getClass().getClassLoader(),
        target.getClass().getInterfaces(),
        new JDKInvocationHandler(target));
  }
}
