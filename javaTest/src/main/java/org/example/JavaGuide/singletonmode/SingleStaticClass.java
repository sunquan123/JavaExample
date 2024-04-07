package org.example.JavaGuide.singletonmode;

/** 静态内部类实现单例模式 */
public class SingleStaticClass {
  private SingleStaticClass() {}

  private static class SingleStaticInnerClass {
    private static final SingleStaticClass INSTANCE = new SingleStaticClass();
  }

  static SingleStaticClass getInstance() {
    return SingleStaticInnerClass.INSTANCE;
  }
}
