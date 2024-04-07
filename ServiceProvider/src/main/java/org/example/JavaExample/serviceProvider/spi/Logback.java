package org.example.JavaExample.serviceProvider.spi;

import org.example.JavaExample.serviceProviderInterface.spi.Logger;

public class Logback implements Logger {
  @Override
  public void info(String s) {
    System.out.println("Logback info 打印日志：" + s);
  }

  @Override
  public void debug(String s) {
    System.out.println("Logback debug 打印日志：" + s);
  }
}
