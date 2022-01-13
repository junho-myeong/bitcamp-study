package com.eomcs.oop.ex05.x1;

// 1) 계산기 객체를 정의한 후 사용하기
public class CalculratorTest {
  public static void main(String[] args) {
    Calculrator c1 = new Calculrator();

    c1.plus(100);
    c1.minus(200);
    System.out.println(c1.result);
  }
}
