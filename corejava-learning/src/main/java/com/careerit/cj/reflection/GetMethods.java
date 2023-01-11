package com.careerit.cj.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Example{
 public void display(){
  System.out.println("The Display Method");
 }
 public void show(int a,int b){
  System.out.println("The Show Method");
 }
 private void print(Object object){
  System.out.println("The Print Method");
 }
}

public class GetMethods {
 public static void main(String[] args) {
  try{
     Class c=Class.forName("com.careerit.cj.reflection.Example");
     Method methods[]=c.getDeclaredMethods();
     for(Method method:methods){
      System.out.println("***********************************************"); 
      System.out.println("Method modifier :" + Modifier.toString(method.getModifiers()));
      System.out.println("Method name : "+method.getName());
      System.out.println("Method return type: "+method.getReturnType());
      Class params[]=method.getParameterTypes();
      for(int i=0;i < params.length;i++){
        System.out.println("Param [i] "+" = "+params[i]);
      }
    }
  }catch (Exception e) {
    System.out.println(e);
  }
 }
}