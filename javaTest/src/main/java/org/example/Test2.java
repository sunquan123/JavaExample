package org.example;

public class Test2 {
  public static void main(String[] args) {
    testMore();
    //        testUnsignedRight();
    //        Integer.valueOf();
  }

  public static void testUnsignedRight() {
    int sign = -2;
    sign = sign >>> 1;
    System.out.println("无符号右移sign:" + sign);
  }

  /** 无符号右移超过int32位限制时，右移42位=右移（42%32）=右移10位 long限制是64位 */
  public static void testMore() {
    int sign = -2;
    sign = sign << 10;
    System.out.println("左移10位的sign:" + sign);
    sign = -2;
    sign = sign << 42;
    System.out.println("左移42位的sign:" + sign);
    sign = -2;
    sign = sign >> 10;
    System.out.println("右移10位的sign:" + sign);
    sign = -2;
    sign = sign >> 42;
    System.out.println("右移42位的sign:" + sign);
  }
}
