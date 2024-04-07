package org.example.javaexample.ServiceProviderSpring;

import org.example.javaexample.serviceProviderInterfaceSpring.spi.SpringLogger;

public class SpringLoggerImpl
    implements SpringLogger {
  @Override
  public void info(String msg) {
    System.out.println("SpringLoggerImpl info:" + msg);
  }

  @Override
  public void debug(String msg) {
    System.out.println("SpringLoggerImpl debug:" + msg);
  }
}
