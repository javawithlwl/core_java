package com.careerit.cj.collections.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OccurrenceOfGiveWordCount {

  public static void main(String[] args) {

    String data = "learning java is fun to have fun learn java";

    String[] arr = data.split(" ");
    System.out.println(Arrays.toString(arr));
    Map<String, Integer> map = new HashMap<>();
    for (String word : arr) {
//        if(map.get(word)==null){
//          map.put(word,1);
//        }else{
//          map.put(word,map.get(word)+1);
//        }
          map.put(word,map.getOrDefault(word,0)+1);
    }
    System.out.println(map);

  }
}
