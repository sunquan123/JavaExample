package org.example.JavaGuide.multithread;

import java.util.concurrent.TimeUnit;

/**
 * 2024-04-06 16:50:13 Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.381-b09 mixed mode):
 *
 * <p>"DestroyJavaVM" #23 prio=5 os_prio=0 tid=0x0000018de8e76000 nid=0x4aec waiting on condition
 * [0x0000000000000000] java.lang.Thread.State: RUNNABLE
 *
 * <p>"Blocked-Thread-2" #22 prio=5 os_prio=0 tid=0x0000018d8ff74800 nid=0xd5c waiting for monitor
 * entry [0x0000000feb7ff000] java.lang.Thread.State: BLOCKED (on object monitor) at
 * org.example.MultiThread.TestThreadState$Blocked.run(TestThreadState.java:51) - waiting to lock
 * <0x0000000716ce0178> (a java.lang.Class for org.example.MultiThread.TestThreadState$Blocked) at
 * java.lang.Thread.run(Unknown Source)
 *
 * <p>"Blocked-Thread-1" #21 prio=5 os_prio=0 tid=0x0000018d8ff74000 nid=0x5098 waiting on condition
 * [0x0000000feb6ff000] java.lang.Thread.State: TIMED_WAITING (sleeping) at
 * java.lang.Thread.sleep(Native Method) at java.lang.Thread.sleep(Unknown Source) at
 * java.util.concurrent.TimeUnit.sleep(Unknown Source) at
 * org.example.MultiThread.TestThreadState$Blocked.run(TestThreadState.java:51) - locked
 * <0x0000000716ce0178> (a java.lang.Class for org.example.MultiThread.TestThreadState$Blocked) at
 * java.lang.Thread.run(Unknown Source)
 *
 * <p>"TimedWaiting-Thread" #20 prio=5 os_prio=0 tid=0x0000018d8ff70000 nid=0x3b0 waiting on
 * condition [0x0000000feb5ff000] java.lang.Thread.State: TIMED_WAITING (sleeping) at
 * java.lang.Thread.sleep(Native Method) at java.lang.Thread.sleep(Unknown Source) at
 * java.util.concurrent.TimeUnit.sleep(Unknown Source) at
 * org.example.MultiThread.TestThreadState$TimedWaiting.run(TestThreadState.java:19) at
 * java.lang.Thread.run(Unknown Source)
 *
 * <p>"Waiting-Thread" #19 prio=5 os_prio=0 tid=0x0000018d8ff6d000 nid=0x6b50 in Object.wait()
 * [0x0000000feb4ff000] java.lang.Thread.State: WAITING (on object monitor) at
 * java.lang.Object.wait(Native Method) - waiting on <0x0000000716cdc1e0> (a java.lang.Class for
 * org.example.MultiThread.TestThreadState$Waiting) at java.lang.Object.wait(Unknown Source) at
 * org.example.MultiThread.TestThreadState$Waiting.run(TestThreadState.java:35) - locked
 * <0x0000000716cdc1e0> (a java.lang.Class for org.example.MultiThread.TestThreadState$Waiting) at
 * java.lang.Thread.run(Unknown Source)
 */
public class TestThreadState {
  public static void main(String[] args) {
    new Thread(new Waiting(), "Waiting-Thread").start();
    new Thread(new TimedWaiting(), "TimedWaiting-Thread").start();
    new Thread(new Blocked(), "Blocked-Thread-1").start();
    new Thread(new Blocked(), "Blocked-Thread-2").start();
  }

  // 有时间的等待
  static class TimedWaiting implements Runnable {
    @Override
    public void run() {
      try {
        while (true) {
          TimeUnit.SECONDS.sleep(100);
        }

      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  // 等待
  static class Waiting implements Runnable {
    @Override
    public void run() {
      while (true) {
        synchronized (Waiting.class) {
          try {
            Waiting.class.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  // 阻塞
  static class Blocked implements Runnable {
    @Override
    public void run() {
      synchronized (Blocked.class) {
        while (true) {
          try {
            TimeUnit.SECONDS.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
