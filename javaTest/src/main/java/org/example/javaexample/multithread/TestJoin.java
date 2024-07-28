package org.example.javaexample.multithread;

import java.util.concurrent.TimeUnit;

public class TestJoin {
  public static void main(String[] args) throws InterruptedException {
    Thread pre = Thread.currentThread();
    for (int j = 0; j < 10; j++) {
      Thread thread = new Thread(new OrderThread(pre), String.valueOf(j) + "-thread");
      thread.start();
      pre = thread;
    }
    TimeUnit.SECONDS.sleep(5);
    System.out.println(Thread.currentThread().getName() + " Terminated!");
  }

  static class OrderThread implements Runnable {
    Thread previous;

    public OrderThread(Thread thread) {
      this.previous = thread;
    }

    @Override
    public void run() {
      try {
        previous.join();
      } catch (Exception e) {
        System.out.println(e);
      } finally {
        System.out.println(Thread.currentThread().getName() + " Terminated!");
      }
    }
  }
}
