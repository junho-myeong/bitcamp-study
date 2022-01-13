package com.eomcs.oop.ex05.x5;

public class CarTest3 {

  public static void main(String[] args) {
    Sedan sedan = new Sedan();

    ElectricEngine electricEngine = new ElectricEngine(sedan);
    electricEngine.chargeBattery(100);
    Trailer trailer = new Trailer(electricEngine);
    trailer.start();
    trailer.run();
    trailer.stop();
    System.out.println("--------------------------------------------");

    Truck truck = new Truck();
    ElectricEngine electricEngine2 = new ElectricEngine(truck);
    electricEngine2.chargeBattery(170);
    Trailer trailer2 = new Trailer(electricEngine2);
    trailer2.start();
    trailer2.run();
    trailer2.stop();

  }

}
