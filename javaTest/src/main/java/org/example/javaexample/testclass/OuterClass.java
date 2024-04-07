package org.example.javaexample.testclass;

public class OuterClass {
  private String name;
  private int age;
  private static String school;

  public String toString() {
    return "我是外部类的对象实例：(name：" + name + ";age：" + age + ")";
  }

  /** 成员内部类可以直接访问外部类的成员变量，即使是private的。内部类的存在可以弥补类的单继承带来的缺陷，可以在类里面创建多个内部类继承多个类完成功能。 */
  public class InnerClass {
    public InnerClass() {
      name = "孙权";
      age = 18;
    }

    public String toString() {
      return "我是成员内部类的对象实例：(name：" + name + ";age：" + age + ")";
    }
  }

  /** 静态内部类是成员内部类的静态版本，它是独立的类，创建时不依赖外部类对象的创建，只能访问外部类静态成员/静态方法。 */
  public static class InnerStaticClass {
    public String _name = "nonstatic";
    public static String _name2 = "static";

    public InnerStaticClass() {
      school = "南京邮电大学";
    }

    public String toString() {
      return "我是静态内部类的对象实例：(school：" + school + ";_name：" + _name + ";_name2：" + _name2 + ")";
    }
  }

  public static void main(String[] args)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    // 必须创建外部类对象，才能创建外部类对象的成员内部类对象。不能直接创建成员内部类对象
    OuterClass outerClass = new OuterClass();
    InnerClass innerClass = outerClass.new InnerClass();
    System.out.println(innerClass.toString());
    // 这样写运行时也会抛出异常
    //    OuterClass.InnerClass innerClassQQ = (InnerClass)
    // Class.forName("com.javaTest.JavaGuide.testClass.OuterClass.InnerClass").newInstance();
    //    System.out.println(innerClassQQ.toString());
    OuterClass outerClassQQ =
        (OuterClass) Class.forName("com.javaTest.JavaGuide.testClass.OuterClass").newInstance();
    System.out.println(outerClassQQ.toString());
    InnerStaticClass innerStaticClass = new InnerStaticClass();
    System.out.println(innerStaticClass.toString());
    // 局部内部类存在方法内或作用域内，可以解决一些复杂问题，同时不用对外抛出类。
    if (true) {
      class BlockInnerClass {
        private String className;

        public BlockInnerClass() {
          this.className = "BlockInnerClass";
        }

        public String toString() {
          return "我是局部内部类的对象实例：(className：" + this.className + ")";
        }
      }
      System.out.println(new BlockInnerClass().toString());
    }
    // 匿名内部类需要一个接口，然后直接new一个接口的实例并实现接口内部的方法，特殊点在于传给匿名内部类的变量需要声明成final。
    System.out.println(
        new IStudent() {
          @Override
          public String getInfo() {
            return "我是匿名内部类的实现类的getInfo方法";
          }
        }.getInfo());
  }
}
