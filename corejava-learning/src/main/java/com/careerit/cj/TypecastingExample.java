package com.careerit.cj;

class Animal {
  public void sound() {
    System.out.println("Animal can make sound");
  }
}

class Cat extends Animal {
  public void meow() {
    System.out.println("Cat makes meow sound");
  }
}

class Dog extends Animal {
  public void woof() {
    System.out.println("Dog makes woof sound");
  }
}

public class TypecastingExample {
  public static void main(String[] args) {
    Animal[] arr = new Animal[]{new Cat(), new Dog(), new Cat(), new Cat(), new Dog(), new Cat()};
    for (Animal obj : arr) {
      if (obj instanceof Cat cat) {
        cat.sound();
        cat.meow();
      } else if (obj instanceof Dog dog) {
        dog.sound();
        dog.woof();
      }
    }
  }
}
