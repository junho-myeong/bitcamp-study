package com.eomcs.oop.ex02;

// # 관련된 기능(메서드)을 묶어 분류하기 : 분류 전
//
public class Exam0210 {

  public static void main(String[] args) {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?

    // 계산 결과를 담을 변수를 준비한다.
    int result = 0;
    Exam0210 test = new Exam0210();


    // 메서드를 호출하여 작업을 수행하고,
    // 리턴 결과는 로컬 변수에 저장한다.
    int test1 = Exam0210.plus(10, 20);
    int test2 = test.plus1(30, 20);
    System.out.println(test1);
    System.out.println(test2);
    result = plus(2, 3);
    result = minus(result, 1);
    result = multiple(result, 7);
    result = divide(result, 3);

    System.out.printf("result = %d\n", result);
  }

  static int plus(int a, int b) {
    return a + b; 
  }
  int plus1(int a, int b) {
    return a + b; // 로컬 변수를 사용하는것이기 때문에 this 를 사용하면 안된다.(this는 인스턴스 변수 사용할때 사용하는 인스턴스 메서드 사용할때)
  }

  static int minus(int a, int b) {
    return a - b;
  }

  static int multiple(int a, int b) {
    return a * b;
  }

  static int divide(int a, int b) {
    return a / b;
  }
}
// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.


