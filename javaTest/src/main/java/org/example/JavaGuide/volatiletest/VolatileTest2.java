package org.example.JavaGuide.volatiletest;
// 这个例子用synchronized保证了多线程操作共享变量的原子性
public class VolatileTest2 extends Thread {
  static volatile int increase = 0;

  static synchronized void increaseFun() {
    increase++;
  }

  public void run() {
    int i = 0;
    while (i < 10000) {
      increaseFun();
      i++;
    }
  }

  public static void main(String[] args) {
    VolatileTest2 vt = new VolatileTest2();
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
  }
}
