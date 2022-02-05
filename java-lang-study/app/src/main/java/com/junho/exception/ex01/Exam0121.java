// 예외 처리 문법을 적용하기 전 - 리턴값으로 오류 여부 판단하기
// 이 방법에 문제점은 정상적인 리턴값을 받았을때도 오류로 판단할수 잇다는 점이다.
package com.junho.exception.ex01;

public class Exam0121 {

  public static void main(String[] args) {
    // 리턴 값을 검사하여 오류 여부를 파악하는 방식은
    // 다음과 같은 문제가 있다.
    // 정상적인 계산 결과도 오류로 취급할수 있다는 점이다.
    int result = Calculator.compute("-", 6, 7);

    // 위의 계산 결과는 정상적인 값이다.
    // 그럼에도 불구하고 다음과 같이 -1을 리턴하는 경우 오류로 간주하기 때문에
    // 잘못된 결과를 출력한다.
    if (result == -1) {
      System.out.println("유효하지 않은 연산자 입니다.");
    } else {
      System.out.println(result);
    }
  }

}
