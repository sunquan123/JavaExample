package org.example.JavaExample.ServiceProviderSpring2;

import org.example.JavaExample.serviceProviderInterfaceSpring.spi.SpringLogger;

public class SpringLoggerImpl2
    implements SpringLogger {
  @Override
  public void info(String msg) {
    System.out.println("SpringLoggerImpl2 info:" + msg);
  }

  @Override
  public void debug(String msg) {
    System.out.println("SpringLoggerImpl2 debug:" + msg);
  }
}
