package com.careerit.cj.eceptions;

class E1Exception extends  Exception{

}
class E2Exception extends  E1Exception{

}
class E3Exception extends  E2Exception{

}
class One{
    public void m1() throws E1Exception{

    }
}
class Two extends  One{
    public void m1(){

    }

}

public class ExceptionWithOverrideExample {
}
