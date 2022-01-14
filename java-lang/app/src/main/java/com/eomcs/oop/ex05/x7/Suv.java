package com.eomcs.oop.ex05.x7;

public class Suv extends Car{
  boolean enabled4wd;

  @Override
  public void run() {
    if(enabled4wd) {
      System.out.println("강하게 달린다");
    }else {
      System.out.println("강하게 달리지 못한다");
    }
  }
  public void active4wd(boolean enable) {
    this.enabled4wd = enable;
  }
}
