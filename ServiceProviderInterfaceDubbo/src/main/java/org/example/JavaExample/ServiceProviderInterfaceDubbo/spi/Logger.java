package org.example.javaexample.ServiceProviderInterfaceDubbo.spi;

import org.apache.dubbo.common.extension.SPI;

/** 服务提供者接口的接口定义 */
@SPI
public interface Logger {
  public void info(String msg);

  public void debug(String msg);
}
