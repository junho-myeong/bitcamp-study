package com.eomcs.oop.ex05.x6;

public class Truck extends Car{
  int weight;

  public void launch() {
    System.out.println("트럭시동 건다");
  }
  public void stopping() {
    System.out.println("트럭 시동 끈다");
  }

  public void go() {
    System.out.println("덜덜 달린다");
  }

  // 기존에 이미 잇는 메서드를 호출한다.
  // CarTest2에서 사용할 메서드를 오버라이딩 해주면서 우리가 옛날에 사용하던 메서드들도 
  // 사용할수 잇다.
  @Override
  public void start() {
    this.launch();
  }
  @Override
  public void run() {
    this.go();
  }
  @Override
  public void stop() {
    this.stopping();
  }
  public void dump() {
    System.out.println("짐을 내린다.");
  }
}
