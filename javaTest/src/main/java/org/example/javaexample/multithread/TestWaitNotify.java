package org.example.javaexample.multithread;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestWaitNotify {
    public static Object lock = new Object();
    public static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new WaitThread(), "WaitThread");
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread2 = new Thread(new NotifyThread(), "NotifyThread");
        thread2.start();
    }

    static class WaitThread implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println(Thread.currentThread() + " flag is false " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }

    static class NotifyThread implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            //中间空隙lock对象的锁被释放，可能先由WaitThread被唤醒执行，可能先由NotifyThread继续获取到时间片二次获取到锁去执行
            // 大部分情况下，都是NotifyThread先执行，除非手动sleep NotifyThread
//            try {
//                TimeUnit.MICROSECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
