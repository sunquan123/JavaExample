package org.example.javaexample.proxy;

public class AliSmsService {
  public String send(String message) {
    System.out.println("AliSmsService send message:" + message);
    return message;
  }
}
