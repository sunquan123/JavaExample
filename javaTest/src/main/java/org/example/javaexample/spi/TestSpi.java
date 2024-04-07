package org.example.javaexample.spi;

import org.example.JavaExample.serviceProviderInterface.spi.LoggerService;

public class TestSpi {
  public static void main(String[] args) {
    LoggerService loggerService = LoggerService.getService();
    loggerService.info("Hello SPI");
    loggerService.debug("Hello SPI");
  }
}
