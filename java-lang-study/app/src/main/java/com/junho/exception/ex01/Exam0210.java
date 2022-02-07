// 예외 처리 문법을 적용하기 전 - 예외 발생시 시스템 멈춤 문제
package com.junho.exception.ex01;

import java.util.Scanner;

public class Exam0210 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.printf("입력>");
      String op = sc.next(); 
      if (op.equals("quit")) {
        break; 
      }
      int i = sc.nextInt();
      int j = sc.nextInt();
      // 다음과 같이 일반적이 예외의 경우 리턴 값을 검사하여 처리하면 된다.
      // 문제는 0으로 나누는경우에서 처럼 계산할 수 없는 예외 상황이 발생한다면
      // JVM은 실행을 종료하게 된다.
      // => 0으로 나눌 때 처럼 예외가 발생하더라도 JVM을 멈추지 않고
      //    계속 정상적으로 실행되게 만드는 문법이 "예외처리" 이다.
      // 즉 예외처리?
      //    => 예외처리란 JVM을 실행하는 도중 특정 예외상황이 발생하였을때 적절한 
      //       조치를 취함으로써 JVM의 실행을 중지 시키지 않는것을 말한다.
      int result = Calculator2.compute(op, i, j);
      if (result == -121212) {
        System.out.println("유효하지 않은 연산자 입니다.");
      } else {
        System.out.println(result);
      }
    }
    sc.close();
  }

}
