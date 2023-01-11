package com.careerit.cj.generics;

public class MyContainer<T>{
      Object[] obj;
      MyContainer(){
          obj = new Object[10];
      }
      public void add(T ele){
          obj[0]=ele;
      }
      public T get(){
        return (T)obj[0];
      }

}
