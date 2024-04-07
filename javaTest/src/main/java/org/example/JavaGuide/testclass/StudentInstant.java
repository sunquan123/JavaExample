package org.example.JavaGuide.testclass;

public class StudentInstant implements IStudent {
  public static final String name = "com.javaTest.JavaGuide.testClass.StudentInstant";

  /**
   * 抽象方法的实现
   *
   * @return
   */
  @Override
  public String getInfo() {
    return "com.javaTest.JavaGuide.testClass.StudentInstant getInfo";
  }

  /**
   * default方法的重写
   *
   * @return
   */
  @Override
  public String getFather() {
    return "com.javaTest.JavaGuide.testClass.StudentInstant getFather";
  }

  public static void main(String[] args) {
    StudentInstant s = new StudentInstant();
    System.out.println(s.getInfo());
    System.out.println(s.getFather());
    System.out.println(s.getName());
  }
}
