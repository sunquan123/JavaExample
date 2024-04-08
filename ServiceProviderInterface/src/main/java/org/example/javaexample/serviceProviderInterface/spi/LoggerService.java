package org.example.javaexample.serviceProviderInterface.spi;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/** 服务调用者接口的调用类 */
public class LoggerService {
  private static final LoggerService SERVICE = new LoggerService();

  private List<Logger> loggerList = new ArrayList<>();

  private Logger logger;

  /** 从系统中读取logger接口的实现类并存起来 */
  private LoggerService() {
    ServiceLoader<Logger> serviceLoaders = ServiceLoader.load(Logger.class);
    for (Logger logger : serviceLoaders) {
      loggerList.add(logger);
    }
    if (loggerList.size() > 0) {
      logger = loggerList.get(0);
    } else {
      logger = null;
    }
  }

  public static LoggerService getService() {
    return SERVICE;
  }

  /**
   * 服务调用者接口提供的调用方法info，内部调用加载进来的服务实现者的实现逻辑
   *
   * @param msg
   */
  public void info(String msg) {
    if (logger == null) {
      System.out.println("info 中没有发现 Logger 服务提供者");
    } else {
      logger.info(msg);
    }
  }

  /**
   * 服务调用者接口提供的调用方法debug，内部循环调用加载进来的服务实现者的实现逻辑
   *
   * @param msg
   */
  public void debug(String msg) {
    if (loggerList.isEmpty()) {
      System.out.println("debug 中没有发现 Logger 服务提供者");
    }
    loggerList.forEach(log -> log.debug(msg));
  }
}
