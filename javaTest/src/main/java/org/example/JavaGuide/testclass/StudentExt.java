package org.example.JavaGuide.testclass;

import org.example.JavaGuide.copy.BaseStudent;

public class StudentExt extends BaseStudent {

  /**
   * 抽象方法的实现
   *
   * @return
   */
  @Override
  public String getInfo() {
    return "com.javaTest.JavaGuide.testClass.StudentExt getInfo";
  }

  /**
   * 父类方法的重写
   *
   * @return
   */
  @Override
  public String getFather() {
    return "com.javaTest.JavaGuide.testClass.StudentExt getFather";
  }

  public static void main(String[] args) {
    StudentExt s = new StudentExt();
    System.out.println(s.getInfo());
    System.out.println(s.getFather());
    s.name = "com.javaTest.JavaGuide.testClass.StudentExt";
    System.out.println(s.getName());
  }
}
