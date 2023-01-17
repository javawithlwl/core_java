package com.careerit.cj.interfaceexample;

interface I1{
      void m1();
      default void m2(){
        System.out.println("This is extra default method");
      }
}
class CC1 implements  I1{

  @Override
  public void m1() {

  }
}
class CC2 implements  I1{

  @Override
  public void m1() {

  }
}

public class InterfaceAndAbstractClass {
}
