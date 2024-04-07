package org.example.javaexample.generic;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TestGeneric {
  public static void main(String[] args) {
    testGenericClass();
    testGenericInterface();
  }

  /** 泛型类实例化、泛型方法调用 */
  public static void testGenericClass() {
    Generic<Integer> generic = new Generic<Integer>(new Integer(12345));
    System.out.println(generic.getName());
    String[] sArray = new String[3];
    sArray[0] = "0";
    sArray[1] = "1";
    sArray[2] = "2";
    generic.genericMethod(sArray);
    InputStream inputStream;
    OutputStream outputStream;
    InputStreamReader inputStreamReader;
    OutputStreamWriter outputStreamWriter;
  }

  /** 泛型接口实现、泛型接口不指定泛型实现 */
  public static void testGenericInterface() {
    GenericInterfaceImpl genericInterface = new GenericInterfaceImpl();
    GenericInterfaceUnImpl<Integer> genericInterfaceUn = new GenericInterfaceUnImpl<Integer>();
    System.out.println(genericInterface.genericMethod());
    System.out.println(genericInterfaceUn.genericMethod());
  }
}
