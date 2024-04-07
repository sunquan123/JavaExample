package org.example.javaexample.copy;

public class testCopy {
  public static void main(String[] args) {
    testShadowCopy();
    testDeepCopy();
  }

  public static void testDeepCopy() {
    DeepPerson s = new DeepPerson(new Address("南京"));
    DeepPerson sCopy = s.clone();
    // false
    System.out.println("testDeepCopy:" + (s.getAddress() == sCopy.getAddress()));
  }

  /** 测试浅拷贝 */
  public static void testShadowCopy() {
    ShadowPerson s = new ShadowPerson(new Address("南京"));
    ShadowPerson sCopy = s.clone();
    // true
    System.out.println("testShadowCopy:" + (s.getAddress() == sCopy.getAddress()));
  }
}
