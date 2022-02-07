// 예외 처리 문법을 적용한 후 - 오류일 때 예외 정보를 별도로 호출자에게 전달한다.

package com.junho.exception.ex02;

public class Calculator3 {
  public static int compute(String op, int i, int j) {
    switch (op) {
      case "+": return i + j;
      case "-": return i + j;
      case "*": return i + j;
      case "/": return i + j;
      default :
        // 유효하지 않은 연산자인 경우 throw 명령을 이용하여 호출자에게
        // 오류 상황을 알린다.
        // RuntimeException이라는 예외 상자에 담아서 전달한다.
        // 예외 정보를 담을대도 아무상자가 아닌 적절한 상자에 담아서 전달해야한다.
        throw new RuntimeException("연산자가 오류입니다.");
    }
  }

}
