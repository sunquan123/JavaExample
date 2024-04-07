package org.example.JavaGuide.proxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibFactory {
  public static Object getCglibProxy(Class<?> clazz) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(clazz);
    enhancer.setClassLoader(clazz.getClassLoader());
    enhancer.setCallback(new CglibMethodInterceptor());
    return enhancer.create();
  }
}
