package org.example.javaexample.proxy;

public class SmsServiceImpl implements SmsService {
  @Override
  public void send() {
    System.out.println("SmsServiceImpl send ok");
  }

}
