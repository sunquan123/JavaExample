package org.example.javaexample.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

// 这里的例子验证了即使用volatile修饰变量，也不能保证多线程下各个线程修改这个变量能原子性操作
public class VolatileTest extends Thread {
  static volatile int increase = 0;
  static AtomicInteger aInteger = new AtomicInteger(); // 对照组

  static void increaseFun() {
    increase++;
    aInteger.incrementAndGet();
  }

  public void run() {
    int i = 0;
    while (i < 10000) {
      increaseFun();
      i++;
    }
  }

  public static void main(String[] args) {
    VolatileTest vt = new VolatileTest();
    int THREAD_NUM = 10;
    Thread[] threads = new Thread[THREAD_NUM];
    for (int i = 0; i < THREAD_NUM; i++) {
      threads[i] = new Thread(vt, "线程" + i);
      threads[i].start();
    }
    // idea中会返回主线程和守护线程，如果用Eclipse的话改为1
    while (Thread.activeCount() > 2) {
      Thread.yield();
    }
    System.out.println("volatile的值: " + increase);
    System.out.println("AtomicInteger的值: " + aInteger);
  }
}
