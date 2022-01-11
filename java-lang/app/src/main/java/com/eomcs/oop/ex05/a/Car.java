package com.eomcs.oop.ex05.a;

public class Car {

  public String model;
  public String maker;
  public int capacity;

  public Car() {}

  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  // 인스턴스 필드를 사용하지 않기 떄문에 보통 실무에서는 클래스 메서드로 사용해야한다.
  public void run() {
    System.out.println("달린다!");
  }
}


