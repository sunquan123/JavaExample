package org.example.JavaExample.serviceProviderInterfaceSpring.spi;

/**
 * 服务提供者接口的接口定义
 */
public interface SpringLogger {
  public void info(String msg);

  public void debug(String msg);
}
