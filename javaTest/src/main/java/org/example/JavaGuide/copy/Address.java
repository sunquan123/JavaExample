package org.example.JavaGuide.copy;

public class Address implements Cloneable {
  private String name;

  public Address(String name) {
    this.name = name;
  }

  public Address() {}

  // 省略构造函数、Getter&Setter方法
  @Override
  public Address clone() {
    try {
      return (Address) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
