package com.junho.oop.ex05.x1.test3;

public class Calculrator2 {
  public int result;

  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }

  // 2번 방법(복제후 기능 추가하기)
  public void mutiple(int value) {
    this.result *= value;
  }
}
