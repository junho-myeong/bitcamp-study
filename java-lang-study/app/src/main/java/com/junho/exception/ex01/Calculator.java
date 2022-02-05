package com.junho.exception.ex01;

public class Calculator {
  public static int compute(String op, int i, int j) {
    switch (op) {
      case "+":
        return i + j;
      case "-":
        return i - j;
      case "*":
        return i * j;
      case "/":
        return i / j;
      default:
        return -1; // 유효 하지 않은 연산자에 경우 -1로 나타낸다.
    }
  }
}
