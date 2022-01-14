package com.eomcs.oop.ex05.x7;

public class Truck extends Car {
  int weight;

  public void launch() {
    System.out.println("시동건다!");
  }
  public void stopping() {
    System.out.println("시동 끈다!");
  }
  public void go() {
    System.out.println("달린다!");
  }
  @Override
  public void run() {
    System.out.println("덜컹덜컹 달린다");
  }
  public void dump() {
    System.out.println("짐을 내린다!");
  }

}
