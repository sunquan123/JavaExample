package org.example.javaexample.testclass;

public interface IStudent {
  public String name = "com.javaTest.JavaGuide.testClass.IStudent";

  public abstract String getInfo();

  public default String getFather() {
    return "com.javaTest.JavaGuide.testClass.IStudent getFather";
  }

  public default String getName() {
    return name;
  }
}
