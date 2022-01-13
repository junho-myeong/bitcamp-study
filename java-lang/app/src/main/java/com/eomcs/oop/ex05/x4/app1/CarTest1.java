package com.eomcs.oop.ex05.x4.app1;


// 자동차를 만들기
// 1) 기존 코드를 상속한 후 새 calss를 만든 후 기능 덧 붙이기.
// 
public class CarTest1 {

  public static void main(String[] args) {
    // Engine 클래스를 상속 받아 Car클래스를 만든다.
    // => start(), stop() 메서드 추가
    // 소스코드는 필요 없이 class 파일만 잇으면 상속 받을수 잇다.

    Car car = new Car();
    car.start();
    car.run();
    car.stop();

  }

}
