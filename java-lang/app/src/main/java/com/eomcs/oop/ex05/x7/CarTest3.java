package com.eomcs.oop.ex05.x7;

public class CarTest3 {

  public static void main(String[] args) {

    testCar(new Sedan());
    System.out.println("---------------------");
    testCar(new Truck());
    System.out.println("----------------------");
    Suv suv = new Suv();
    suv.active4wd(true);
    testCar(suv);
    System.out.println("----------------------");
    Suv suv1 = new Suv();
    suv1.active4wd(false);
    testCar(suv1);

  }

  public static void testCar(Car car) {
    Sedan sedan = new Sedan();
    car.start();
    car.run();
    car.stop();
  }

}
