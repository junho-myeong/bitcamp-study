package com.eomcs.oop.ex05.x4.app4;

import com.eomcs.oop.ex05.x4.app1.Car;

public class HybridCar extends Car{
  //하이브리드 자동차 기능 추가
  int kwh;

  public void chargeBattery(int kwh) {
    this.kwh = kwh;
  }

  // superClass로 부터 상속 받은 run() 메서드를 현재 클래스의 역활에 맞게 재 정의 한ㄷ.ㅏ
  @Override
  public void run() {
    if (kwh > 0) {
      System.out.println("전기로 움직인다.");
    }else {
      super.run();
    }

  }
}
