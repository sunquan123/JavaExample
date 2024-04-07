package org.example.javaexample.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestLinkedHashMap {
  public static void main(String[] args) {
    LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap();

    linkedHashMap.put("a", "2");
    linkedHashMap.put("g", "1");
    linkedHashMap.put("r", "4");
    linkedHashMap.put("e", "3");
    for (Map.Entry<String, String> stringStringEntry : linkedHashMap.entrySet()) {
      System.out.println(stringStringEntry.getKey() + "=" + stringStringEntry.getValue());
    }
  }
}
