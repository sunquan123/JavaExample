package org.example.javaexample.dubbospi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.example.JavaExample.ServiceProviderInterfaceDubbo.spi.Logger;

public class TestDubboSpi {
  public static void main(String[] args) {
    System.out.println("======dubbo SPI======");
    ExtensionLoader<Logger> extensionLoader = ExtensionLoader.getExtensionLoader(Logger.class);
    Logger FirstLoggerServiceImpl = extensionLoader.getExtension("First");
    FirstLoggerServiceImpl.info("TestDubboSpi");
    Logger SecondLoggerServiceImpl = extensionLoader.getExtension("Second");
    SecondLoggerServiceImpl.info("TestDubboSpi");
  }
}
