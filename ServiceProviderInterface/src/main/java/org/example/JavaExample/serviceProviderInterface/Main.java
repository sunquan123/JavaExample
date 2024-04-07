package org.example.javaexample.serviceProviderInterface;

import org.example.javaexample.serviceProviderInterface.spi.LoggerService;

public class Main {
  public static void main(String[] args) {
    LoggerService loggerService = LoggerService.getService();
    loggerService.info("Hello SPI");
    loggerService.debug("Hello SPI");
  }
}
