package org.example.JavaGuide.stringpool;

import java.io.File;

import static java.lang.StringTemplate.STR;

public class StringTest {
  public static void main(String[] args) {
    // 创建字符串常量池中"a"，创建堆中string对象，对象指向常量池中"a"，reference1引用堆中string对象地址
    String reference1 = new String("a");
    // intern方法先去字符串常量池中找是否有"a"字符串，此时常量池中已经有"a"了，直接返回给reference0常量池中的对象地址引用
    String reference0 = reference1.intern();
    // 字符串字面量赋值时也先去字符串常量池中找是否有"a"字符串，此时常量池中已经有"a"了，直接返回给reference2常量池中的对象地址引用
    String reference2 = "a";
    System.out.println(reference1 == reference2); // 堆中string对象地址 != 常量池中对象地址
    System.out.println(reference1 == reference0); // 堆中string对象地址 != 常量池中对象地址
    System.out.println(reference0 == reference2); // 常量池中对象地址 == 常量池中对象地址
    System.out.println("---------------------------");

    // 创建堆中对象StringBuilder，创建字符串常量池中"a"，创建堆中string对象指向常量池中"a"，创建堆中string对象指向常量池中"a"，stringBuilder对象执行toString方法创建堆中string对象"aa"，此时常量池中没有"aa"
    String reference3 = new String("a") + new String("a");
    // intern方法先去常量池中找是否有"aa"字符串，此时常量池中没有。则在字符串常量池中存储一个指向堆中string对象"aa"的引用，并把这个引用返回给reference4
    String reference4 = reference3.intern();
    // 字符串字面量赋值时也会先去字符串常量池中查找是否有"aa"字符串，此时常量池中已经有"aa"字符串的引用了，直接返回给reference5常量池中的这个新引用，新引用指向堆中string对象"aa"
    String reference5 = "aa";
    System.out.println(reference3 == reference4);
    System.out.println(reference3 == reference5);
    System.out.println(reference4 == reference5);
    // jdk21 字符串变量替换测试
    String filePath = "D:\\aa\\aa.txt";
    File file = new File(filePath);
    String msg = STR."The file \{filePath} \{file.exists()? "does" : "does not"} exist";
    // jdk21 字符串模版测试
    System.out.println(msg);
    String name="abc";
    String html=STR."""
        <html>
          <title>welcome to my page</title>
          <body>\{name}</body>
        </html>""";
    System.out.println(html);
    //Thread.startVirtualThread(new SimpleThread());
  }
}
