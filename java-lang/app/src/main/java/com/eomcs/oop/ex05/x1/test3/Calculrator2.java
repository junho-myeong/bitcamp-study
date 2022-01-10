package com.eomcs.oop.ex05.x1.test3;

// 기존의 Calculrator 클래스를 복제한후 추가한다.
public class Calculrator2 {
  int result;

  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }

  // 2번 방법(새로 추가한 기능)
  public void multiple(int value) {
    this.result *= value;
  }

}
