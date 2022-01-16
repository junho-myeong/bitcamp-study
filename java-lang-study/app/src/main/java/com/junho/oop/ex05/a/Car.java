package com.junho.oop.ex05.a;

public class Car {
  String maker;
  String model;
  int capacity;
  // 생성자 함수를 정의하지 않으면 컴파일러가 자동으로 생성자 함수를 정의한다.
  // 생성자의 특징은 클래스이름이랑 생성사 함수 이름이 서로 같아야한다.
  // 생성자는 return이 없기 떄문에 return 타입을 정의하면 안된다.
  Car() /*extends Object*/{
    // 자바의 모든 클래스는 Object클래스를 상속 받는다.
    // 그리고 super class를 호출 하는 방법은
    //    super() 메서드를 통해 호출할수잇다.
    //    우리가 super 지정해주지 않으면, 컴파일러가 자동으로 super class를 호출한다.
    //    단 호출 할때 super class에 default 생성자를 호출한다. 
    //    단 super class에 default 생성자가 없으면 파라미터에 맞게 호출해줘야한다.
  }

  public Car(String maker, String model, int capacity) {
    this.maker = maker;
    this.model = model;
    this.capacity = capacity;
  }
  public static void run() {
    System.out.println("달린다!");
  }
}
