package com.eomcs.oop.ex02;

import com.eomcs.oop.ex02.util.Calculator4;

// 클래스 사용하는 이유2: 관련된 기능(메서드)를 묶어 분류하기 - 클래스로 분류
// 1) 관련된 기능을 클래스로 묶기
// 2) 변수를 밖에서 사용하지 않고 클래스 내부에서 사용하기
// => 클래스 변수는:
// => 단점은 result 결과를 한번 밖에 사용하지 못한다.


public class ExamTest22 {


  public static void main(String[] args) {

    // 2 + 3 - 1 * 7 / 3 = ?
    Calculator4 c = new Calculator4();

    c.plus(2);
    c.plus(3);
    c.minus(1);
    c.multiple(7);
    c.divide(3);

    System.out.printf("result = %d\n", c.getResult());
  }


}



