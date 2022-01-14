package com.eomcs.oop.ex05.x5;

public abstract class Car {
  public void start() {
    System.out.println("시동 건다!");
  }
  public void stop() {
    System.out.println("시동 끈다!");
  }
  public abstract void run(); // 추상 메서드
  // 추상 메서드로 선언하는 이유는 이 클래스에 sub class 에서 
  // sub class에 역활에 따라 특별한 기능을 부여할 것이기 때문에
  // 추상클래스로 선언하는것이고 
  // 꼭 이 기능은 추가 하긴해야한다고 말해주는것이다.
}
