package org.example.MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestPriority {
  public static boolean notStart = true;
  public static boolean notEnd = true;

  // 线程设置priority优先级在一些操作系统上不一定生效，所以不能依赖这个属性开发多线程程序
  public static void main(String[] args) throws InterruptedException {
    List<Job> jobList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
      Job job = new Job(priority);
      jobList.add(job);
      Thread thread = new Thread(job);
      thread.setPriority(priority);
      thread.start();
    }
    notStart = false;
    TimeUnit.SECONDS.sleep(10);
    notEnd = false;
    for (Job job : jobList) {
      System.out.println("Job priority:" + job.priority + " job count:" + job.jobCount);
    }
  }

  public static class Job implements Runnable {
    private int priority;
    private long jobCount;

    public Job(int priority) {
      this.priority = priority;
    }

    @Override
    public void run() {
      while (notStart) {
        Thread.yield();
      }

      while (notEnd) {
        Thread.yield();
        jobCount++;
      }
    }
  }
}
