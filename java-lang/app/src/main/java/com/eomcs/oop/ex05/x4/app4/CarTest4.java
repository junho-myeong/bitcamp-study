package com.eomcs.oop.ex05.x4.app4;

// 하이브리드 자동차 만들기
//
// 1) 상속을 통해 기능을 연결하여 기능추가하기
// 
public class CarTest4 {

  public static void main(String[] args) {
    // 하이브리드 기능 추가하기
    // Car클래스를 상속 받아 HybridCar 클래스를 만든후 전기차 기능을 추가한다.
    // => kwh변수추가
    // => chargeBattery()메서드 추가
    // => run()메서드 오버라이딩

    HybridCar car = new HybridCar();
    car.chargeBattery(170);
    car.start();
    car.run();
    car.stop();
  }

}
