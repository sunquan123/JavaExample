package org.example.javaexample.ServiceProviderDubbo.spi;


import org.example.javaexample.ServiceProviderInterfaceDubbo.spi.Logger;

public class FirstLoggerServiceImpl implements Logger {
  @Override
  public void info(String s) {
    System.out.println("FirstLoggerServiceImpl info 打印日志：" + s);
  }

  @Override
  public void debug(String s) {
    System.out.println("FirstLoggerServiceImpl debug 打印日志：" + s);
  }
}
