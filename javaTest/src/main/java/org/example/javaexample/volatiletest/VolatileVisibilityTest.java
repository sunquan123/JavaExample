package org.example.javaexample.volatiletest;

public class VolatileVisibilityTest {
  public static boolean flag = false;

  public static void changeCondition() {
    flag = true;
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println("working and waiting for change...");
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                while (!flag) {}
              }
            })
        .start();

    Thread.sleep(200);

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                changeCondition();
                System.out.println("condition has changed.");
              }
            })
        .start();

    Thread.sleep(200);
    System.out.println("work done.");
  }
}
