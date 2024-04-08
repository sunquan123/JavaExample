package org.example.javaexample.spi;

import org.example.javaexample.serviceProviderInterface.spi.LoggerService;

public class TestSpi {
  public static void main(String[] args) {
    LoggerService loggerService = LoggerService.getService();
    loggerService.info("Hello SPI");
    loggerService.debug("Hello SPI");
  }
}
