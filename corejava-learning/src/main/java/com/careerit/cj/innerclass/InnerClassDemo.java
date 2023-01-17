package com.careerit.cj.innerclass;

import java.util.List;

class Outer{
    private List<String> list = List.of("one","two","three");
    class Inner{
          public void showElements(){
              for(String name:list){
                System.out.println(name);
              }
          }
          public String firstElement(){
             return list.get(0);
          }
    }
    public Inner inner(){
        return new Inner();
    }
}
public class InnerClassDemo {
  public static void main(String[] args) {
          Outer obj = new Outer();
          Outer.Inner inner = obj.inner();
          inner.showElements();
  }
}
