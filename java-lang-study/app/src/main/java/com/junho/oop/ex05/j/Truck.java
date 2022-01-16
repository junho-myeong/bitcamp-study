package com.junho.oop.ex05.j;

public class Truck extends Car{
  @Override
  public void run() {
    System.out.println("조심히 달린다.");
  }
  public void dump() {
    System.out.println("짐을 내린다.!!");
  }
}
