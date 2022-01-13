package com.eomcs.oop.ex05.j;

public class Car {

  public String model;
  public String maker;
  public int capacity;

  public Car() {} // 기본생성자 디폴트 컨스트럭터

  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public void run() {
    System.out.println("달린다!");
  }
}


