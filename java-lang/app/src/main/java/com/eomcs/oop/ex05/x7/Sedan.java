package com.eomcs.oop.ex05.x7;

public class Sedan extends Car {
  boolean auto;
  boolean opendSunroof;

  @Override
  public void run() {
    System.out.println("씽씽 달린다!");
  }
  public void openSunroof() {
    System.out.println("썬루프 연다");
  }
  public void closeSunroof() {
    System.out.println("썬루프 닫는다");
  }
}
