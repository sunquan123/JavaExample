package org.example.JavaGuide.generic;

public class Generic<T> {
  public T name;

  public Generic(T input) {
    this.name = input;
  }

  public T getName() {
    return this.name;
  }

  public <E> void genericMethod(E[] inputArray) {
    for (E e : inputArray) {
      System.out.printf("%s", e);
    }
    System.out.println();
  }
}
