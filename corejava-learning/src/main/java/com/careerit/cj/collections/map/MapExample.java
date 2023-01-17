package com.careerit.cj.collections.map;

import lombok.*;

import java.util.*;

public class MapExample {

  public static void main(String[] args) {

    Map<Integer, String> map = new HashMap<>();
    map.put(1001, "Krish");
    map.put(1002, "Manoj");
    map.put(1003, "Charan");
    map.put(1001, "Krishna");

    map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

    Set<Integer> keySet = map.keySet();
    for (Integer key : keySet) {
      String value = map.get(key);
      System.out.println(key + " " + value);
    }

    Collection<String> values = map.values();
    for(String value:values){
      System.out.println(value);
    }

    Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

    for(Map.Entry<Integer,String> entry:entrySet){
      System.out.println(entry.getKey()+" "+entry.getValue());
    }

    Map<CustomKey,Map<String, List<String>>> complexMap = new HashMap<>();

  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @EqualsAndHashCode
  class CustomKey{
      private String code;
      private String name;
  }
}
