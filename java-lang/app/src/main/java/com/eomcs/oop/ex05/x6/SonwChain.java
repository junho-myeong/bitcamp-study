package com.eomcs.oop.ex05.x6;

public class SonwChain extends Option {

  public SonwChain(Car car) {
    super(car);
  }
  @Override
  public void run() {
    System.out.println("도로 마찰력을 증가 시킨다");
    car.run();
  }
}
