package com.junho.oop.ex05.l;

public class Sedan extends Car{
  @Override
  public void run() {
    System.out.println("세단은 쌩쌩 달린다.");
  }

  public void doSunroof(boolean open) {
    if (open) {
      System.out.println("썬루프를 연다.");
    } else {
      System.out.println("썬루프를 닫는다.");
    }
  }
}