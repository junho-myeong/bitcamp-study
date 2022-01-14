package com.eomcs.oop.ex05.x6;

public abstract class Option extends Car{
  Car car;
  public Option(Car car) {
    this.car = car;
  }
  @Override
  public void start() {
    // 데코레이터는 자동차가 아니다.
    // 따라서 시동을 걸라는 요청이 들어오면
    // 데이코레이터를 붙인 자동차에게 위임해야한다.
    car.start();
  }
  @Override
  public void stop() {
    // 데코레이터는 자동차가 아니다.
    // 따라서 시동을 끄라는 요청이 들어오면
    // 데이코레이터를 붙인 자동차에게 위임해야한다.
    car.stop();
  }
}
