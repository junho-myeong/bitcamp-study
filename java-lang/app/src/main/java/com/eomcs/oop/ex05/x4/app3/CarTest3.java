package com.eomcs.oop.ex05.x4.app3;


// 캠핑카 만들기
//
// 1) 기존 코드를 상속하여 새 클래스를 만든후 새 기능 추가하기
// 
public class CarTest3 {

  public static void main(String[] args) {
    // CampingTrailer 클래스를 만든다.

    // Car클래스를 상속 받아 TrailerCar클래스를 만든후 트레일러에 관한 기능을 추가했다.
    // - trailer변수 추가
    // setTrailer() 추가
    // - run()메서드 오버라이딩!!!!!

    CampingTrailer trailer = new CampingTrailer();
    TrailerCar car = new TrailerCar();
    car.setTrailer(trailer);
    car.start();
    car.run();
    car.stop();

  }

}
