package org.example.JavaGuide.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
  public static void main(String[] args)
      throws ClassNotFoundException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException,
          InvocationTargetException,
          NoSuchFieldException {
    // 反射创建class对象，生成类实例
    Class<?> targetClass = Class.forName("org.example.JavaGuide.reflect.TargetObject");
    TargetObject targetObject = (TargetObject) targetClass.newInstance();
    // 打印类内部所有方法
    for (Method method : targetClass.getMethods()) {
      System.out.println(method.getName());
    }
    System.out.println("------------------");
    // 调用public方法
    //        Method publicMethod = targetClass.getMethod("publicMethod", String.class);
    Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
    String result = (String) publicMethod.invoke(targetObject, "Java");
    System.out.println(result);

    // 设置类对象中成员变量值
    Field field = targetClass.getDeclaredField("value");
    field.setAccessible(true);
    field.set(targetObject, "JavaValue");
    System.out.println("------------------");
    // 调用private方法
    Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
    privateMethod.setAccessible(true);
    String result2 = (String) privateMethod.invoke(targetObject);
    System.out.println(result2);
  }
}
