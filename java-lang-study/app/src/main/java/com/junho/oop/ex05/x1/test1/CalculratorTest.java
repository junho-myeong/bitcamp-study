package com.junho.oop.ex05.x1.test1;

public class CalculratorTest {

  public static void main(String[] args) {
    Calculrator c1 = new Calculrator();

    c1.plus(100);
    c1.minus(200);

    System.out.println(c1.result);
  }

}
