package org.example.JavaExample.serviceProviderInterface;

import org.example.JavaExample.serviceProviderInterface.spi.LoggerService;

public class Main {
  public static void main(String[] args) {
    LoggerService loggerService = LoggerService.getService();
    loggerService.info("Hello SPI");
    loggerService.debug("Hello SPI");
  }
}
