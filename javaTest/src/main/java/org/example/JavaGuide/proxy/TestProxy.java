package org.example.JavaGuide.proxy;

public class TestProxy {
  public static void main(String[] args) {
    testJDKProxy();
    testCglibProxy();
  }
  static void testJDKProxy(){
    SmsServiceImpl smsService = new SmsServiceImpl();
    // 这里不能将代理得到的对象转换成实现类，否则会报错java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to org.example.JavaGuide.Proxy.SmsServiceImpl
    // 只能将代理得到的对象转换成接口，所以jdk动态代理应当没办法对除了接口定义方法外的方法进行代理实现。
    // SmsServiceImpl proxy = (SmsServiceImpl) JDKInvocationHandlerFactory.getProxy(smsService);
    SmsService proxy = (SmsService) JDKInvocationHandlerFactory.getProxy(smsService);
    proxy.send();
  }
  static void testCglibProxy(){
    AliSmsService cglibProxy = (AliSmsService) CglibFactory.getCglibProxy(AliSmsService.class);
    cglibProxy.send("java");
  }
}
