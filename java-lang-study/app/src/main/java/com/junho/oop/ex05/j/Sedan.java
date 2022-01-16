package com.junho.oop.ex05.j;

// 기존의 Car 클래스를 상속 받아 특별한 기능을 덧붙인다.
// - 이것을 전문화(specialization)이라고 부른다.
public class Sedan extends Car{
  @Override
  public void run() {
    System.out.println("쌩쌩 달린다.!!!");
  }
  public void doSunroof(boolean open) {
    if(open) {
      System.out.println("썬루프 연다");
    }else {
      System.out.println("썬루프 닫는다.");
    }
  }
}
