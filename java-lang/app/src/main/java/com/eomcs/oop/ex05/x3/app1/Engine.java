package com.eomcs.oop.ex05.x3.app1;

public class Engine {
  int cc;
  int valve;

  public void run() {
    System.out.println("엔진이 돈다!");
  }

  // 자동차 기능 추가
  public void start() {
    System.out.println("시동건다!");
  }
  public void stop() {
    System.out.println("시동 끈다!");
  }
}
