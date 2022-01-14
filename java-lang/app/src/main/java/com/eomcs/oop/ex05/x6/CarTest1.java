package com.eomcs.oop.ex05.x6;

public class CarTest1 {

  public static void main(String[] args) {
    Sedan sedan = new Sedan(); // carTest1 과 Sedan은 서로 관계를 맺엇다(coupling)이라고 부른다
    Truck truck = new Truck();
    testSedan(sedan);
    System.out.println("-----------------------------");
    testTruck(truck);

  }
  public static void testSedan(Sedan sedan) {
    sedan.start();
    sedan.run();
    sedan.stop();
  }
  public static void testTruck(Truck truck) {
    truck.launch();
    truck.go();
    truck.stopping();
  }
}
