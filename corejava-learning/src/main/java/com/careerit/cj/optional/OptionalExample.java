package com.careerit.cj.optional;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@FunctionalInterface
interface MyPredicate<T>{
    boolean test(T t);
    default void greet(){
      System.out.println("Greeting from my functional interface");
    }
    private void greetAgain(){
      System.out.println("Greetings from my functional interface");
    }
    static void simpleGreetings(){
      System.out.println("Hello, How are you?");
    }
}



public class OptionalExample {

  public static void main(String[] args) {

    // Functional Interface 8

    MyPredicate<Integer> even = (val) ->val % 2 == 0;

    MyPredicate<Integer> odd = val-> val % 2 != 0;

    Optional<Integer> opt = stringToInt("123A");
    System.out.println(opt.isPresent());
    opt.ifPresent(e->{
      System.out.println(e.toString());
    });

    opt.map(ele -> ele * 2).ifPresent(ele->{
      System.out.println("Value is present :"+ele);
    });
    int res=opt.orElse(45);
    System.out.println("Result :"+res);

    res= opt.orElseGet(() ->{
      System.out.println("Using or else get");
      return 450;
    });
    System.out.println("Result :"+res);
    opt.orElseThrow(()->new IllegalArgumentException("With out key data can't encrypted"));

    opt.ifPresentOrElse(value-> System.out.println("Value present :"+value),
        ()-> System.out.println("Value is not present"));
  }

  public static Optional<String> getName(String str) {
    List<String> list = List.of("Krish", "Manoj", "Charan", "Krishna", "Satya", "Jayesh");
    Optional<String> opt = list.stream().findFirst();
//    String res = null;
//    for (String name : list) {
//      if (name.contains(str)) {
//        res = name;
//        break;
//      }
//    }
    return opt;
  }
  public static Optional<Integer> stringToInt(String s){
      try{
          return Optional.of(Integer.parseInt(s));
      }catch (NumberFormatException e){
          return Optional.empty();
      }
  }

}
