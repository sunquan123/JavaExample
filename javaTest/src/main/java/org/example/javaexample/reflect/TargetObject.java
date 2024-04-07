package org.example.javaexample.reflect;

public class TargetObject {
  private String value;

  public TargetObject() {
    this.value = "c++";
  }

  public String publicMethod(String input) {
    return "I love " + input;
  }

  private String privateMethod() {
    return "value:" + this.value;
  }
}
