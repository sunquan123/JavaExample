package org.example.javaexample.springspi;

import java.util.Iterator;
import java.util.List;
import org.example.JavaExample.serviceProviderInterfaceSpring.spi.SpringLogger;
import org.springframework.core.io.support.SpringFactoriesLoader;

public class TestSpringSpi {
  public static void main(String[] args) {
    List<SpringLogger> springLoggerList =
        SpringFactoriesLoader.loadFactories(
            SpringLogger.class, TestSpringSpi.class.getClassLoader());
    Iterator<SpringLogger> iterator = springLoggerList.iterator();
    while (iterator.hasNext()) {
      SpringLogger next = iterator.next();
      next.info("TestSpringSpi");
    }
    System.out.println("执行结束");
  }
}
