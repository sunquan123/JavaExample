package org.example.javaexample.multithread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class TestThreadNum {
  public static void main(String[] args) {
    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
    for (ThreadInfo threadInfo : threadInfos) {
      System.out.println(
          "["
              + threadInfo.getThreadId()
              + "]  ThreadName:["
              + threadInfo.getThreadName()
              + "]  ThreadState:["
              + threadInfo.getThreadState()
              + "]");
    }
  }
}
