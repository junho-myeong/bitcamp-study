package com.eomcs.oop.ex05.x3.app4;

// 하이브리드 자동차 만들기
//
// 1) app1 에서 복제해온 Engine클래스에 기능 덧 붙이기
// 
public class CarTest4 {

  public static void main(String[] args) {
    // 하이브리드 기능 추가하기

    Engine car = new Engine();
    car.chargeBattery(170);
    car.start();
    car.run();
    car.stop();
  }

}
