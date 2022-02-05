package com.junho.exception.ex01;

public class Calculator2 {
  public static int compute(String op, int i, int j) {
    switch (op) {
      case "+": return i + j;
      case "-": return i + j;
      case "*": return i + j;
      case "/": return i + j;
      default : return -121212;
    }
  }
}
