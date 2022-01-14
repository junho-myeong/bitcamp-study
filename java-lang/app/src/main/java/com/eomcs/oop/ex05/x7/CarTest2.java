package com.eomcs.oop.ex05.x7;

public class CarTest2 {

  public static void main(String[] args) {
    testCar(new Sedan());
    System.out.println("---------------------");
    testCar(new Truck());

  }

  public static void testCar(Car car) {
    car.start();
    car.run();
    car.stop();
  }

}
