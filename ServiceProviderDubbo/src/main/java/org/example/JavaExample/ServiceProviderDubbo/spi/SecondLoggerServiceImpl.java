package org.example.JavaExample.ServiceProviderDubbo.spi;

import org.example.JavaExample.ServiceProviderInterfaceDubbo.spi.Logger;


public class SecondLoggerServiceImpl implements Logger {
  @Override
  public void info(String s) {
    System.out.println("SecondLoggerServiceImpl info 打印日志：" + s);
  }

  @Override
  public void debug(String s) {
    System.out.println("SecondLoggerServiceImpl debug 打印日志：" + s);
  }
}
