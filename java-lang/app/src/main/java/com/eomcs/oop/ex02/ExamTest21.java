package com.eomcs.oop.ex02;
// 1) 관련 메서드를 클래스로 묶는다.
// 2) 메서드에서 계산한 결과를 클래스 변수에 저장한다. 클래스 변수랑 클래스 메서드는 그 클래스 자체에 접근해야 사용가능하다.
// => 클래스 변수를 사용하면 발생하는 단점은, result 변수를 한번밖에 사용하지 못한다 라는 단점이 잇다.,
// => 그래서 여러번 사용하기 위해서는 클래스 변수대신 인스턴스 변수로 사용해야 한다.
// 3) 인스턴스 변수로 바꿔서 결과를 개별적으로 관리한다.
// 4) 인스턴스 메서드로 바꿔서 인스턴스 주소를 this 변수에 받는다.
// 5) 클래스를 별도의 소스 파일로 분리한다.

import com.eomcs.oop.ex02.util.Calculator3;

public class ExamTest21 {



  public static void main(String[] args) {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?
    Calculator3 c1 = new Calculator3();

    c1.plus(2);
    c1.plus(3);
    c1.minus(1);
    c1.multiple(7);
    c1.divide(3);

    System.out.printf("result = %d\n", c1.getResult());
  }


}



