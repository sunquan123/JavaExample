package org.example.javaexample.JUC;

public class TestPaddingData {

  static class Padding {
    // 缓存行1
    long p1, p2, p3, p4, p5, p6, p7;
    volatile long p8 = 0L;
    // 缓存行2
    long p9, p10, p11, p12, p13, p14, p15;
    volatile long p16 = 0L;
  }

  @jdk.internal.vm.annotation.Contended
  public static class JVMPadding {
    volatile long value;

    JVMPadding(long c) {
      value = c;
    }
  }

  public static void main(String[] args) {}
}
