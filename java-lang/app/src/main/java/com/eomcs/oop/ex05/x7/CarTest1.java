package com.eomcs.oop.ex05.x7;

public class CarTest1 {

  public static void main(String[] args) {
    testSedan(new Sedan());
    System.out.println("---------------------");
    testTruck(new Truck());

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
