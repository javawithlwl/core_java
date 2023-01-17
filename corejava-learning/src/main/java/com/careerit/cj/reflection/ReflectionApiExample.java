package com.careerit.cj.reflection;

import java.lang.reflect.Method;

class One{


    public void m1(){

    }
}
class Two extends  One{
    public void m2(){

    }
    private void m3(){

    }
}

public class ReflectionApiExample {

  public static void main(String[] args) {

    try {
      Class cls = Class.forName(args[0]);
      Method[] methods = cls.getDeclaredMethods();

      for(Method method:methods){
        System.out.println(method);
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}
