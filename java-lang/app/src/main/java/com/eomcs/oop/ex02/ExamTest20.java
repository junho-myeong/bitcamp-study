package com.eomcs.oop.ex02;

import com.eomcs.oop.ex02.util.Calculator2;

// 클래스를 사용하는 이유
// 1. 사용자 정의 데이터 타입
//  => 자바에서 기본으로 제공하지 않는 데이터 타입을 사용하기 위해서
// 2. 메서드 분류: 관련된 기능을 묶어서 클래스단위로 사용
//  => 유지 보수쉽게 하기 위해서

public class ExamTest20 {
  //2 + 3 - 1 * 7 / 3 = ?


  public static void main(String[] args) {
    Calculator2 c1 = new Calculator2();
    // 2 + 3 - 1 * 7 / 3 = ?
    c1.plus(2);
    c1.plus(3);
    c1.minus(1);
    c1.multiple(7);
    c1.divide(3);
    System.out.printf("result = %d\n", c1.getResult());

  }


}


