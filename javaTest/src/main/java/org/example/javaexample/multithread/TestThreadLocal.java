package org.example.javaexample.multithread;

import java.util.concurrent.TimeUnit;

public class TestThreadLocal {
  public static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

  static void start() {
    threadLocal.set(System.currentTimeMillis());
  }

  static Long end() {
    return System.currentTimeMillis() - threadLocal.get();
  }

  public static void main(String[] args) throws InterruptedException {
    TestThreadLocal.start();
    TimeUnit.SECONDS.sleep(1);
    System.out.println("cost: " + TestThreadLocal.end() + "ms");
  }
}
