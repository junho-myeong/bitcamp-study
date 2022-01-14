package com.eomcs.oop.ex05.x6;

public class CarTest2 {

  public static void main(String[] args) {
    Sedan sedan = new Sedan(); // carTest1 과 Sedan은 서로 관계를 맺엇다(coupling)이라고 부른다
    Truck truck = new Truck();
    Suv suv = new Suv();
    testCar(sedan);
    System.out.println("-----------------------------");
    testCar(truck);
    System.out.println("-----------------------------");
    suv.active4wd(true);
    testCar(suv);
  }
  public static void testCar(Car car) { // 다형적 변수의 예이다
    car.start();
    car.run();
    car.stop();
    // car.openSunroof(); 
    // 현재 car에는 Car 타입이 들어 잇기 떄문에 컴파일러에서는 car에서 접근 할수잇는 
    // 필드와 메서드만 접근 할수 잇다. 그래서 오류가 나는것이다
  }
}
