// 예외 처리 문법을 적용한 후 - 메서드가 던지는 예외 정보를 받는다.
package com.eomcs.exception.ex2;

public class Exam0110 {
  public static void main(String[] args) {
    String op = "/";
    int a = 7;
    int b = 0;

    // 리턴 값으로 예외 상황을 알리는 것이 아니라,
    // 예외 정보를 던지는 방식으로 호출자에게 알린다.
    try {
      // 예외를 던질 수도 있는 메서드를 호출할 때는 try 블록 안에서 호출한다.
      int result = Calculator3.compute(op, a, b); // 여기서 예외가 발생하면 예외를 던진다.
      System.out.println(result);

    } catch (RuntimeException e) { // 예외를 받는 문법이다.
      // try 블록 안에서 메서드를 호출하다가 예외가 발생하면
      // catch 블록에서 파라미터로 받는다.
      System.out.println(e.getMessage());
      // 런타임 오류일때 는 런타임 오류에 대한 메세지를 주고 
      // 연산자 오류일때는 연산자 오류라고 준다
    }
  }
}


