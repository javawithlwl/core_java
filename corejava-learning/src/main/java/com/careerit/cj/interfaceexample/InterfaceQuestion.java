package com.careerit.cj.interfaceexample;

interface One{
    int a=10;
    void m1();
}
interface Two extends One{
    void m2();
}
class C1 implements One,Two{


  @Override
  public void m1() {

  }

  @Override
  public void m2() {

  }
}
public class InterfaceQuestion {
}
