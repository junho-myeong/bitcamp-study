// 생성자 활용 예 - java.util.Date 클래스의 생성자
package com.eomcs.oop.ex04;

import java.util.Date;

public class Exam0120 {
  // 클래스를 봤을때 클래스의 본질을 알아야한다. 1 사용자 데이터 타입인지?, 2.기능별로 묶어 놓은 클래스인지?

  public static void main(String[] args) throws Exception {
    // java.util.Date 클래스는 날짜 데이터를 다루는 클래스이다.
    // => 이 클래스에는 날짜 데이터를 다룰 수 있는 다양한 메서드가 들어 있다.

    // Date() 기본 생성자는 메모리를 오늘 날짜 값으로 초기화시킨다.
    Date d1 = new Date();
    System.out.println(d1); // 어떤 객체를 넘기든 간엔 println은 toString은 찾아서 리턴한 값을 출력하는것이다.

    // 년, 월, 일 값으로 날짜 인스턴스를 초기화시킨다.
    Date d2 = new Date(122, 4, 3); // 다른 개발자가 만든 생성자를 보고 우리가 사용하는것이기 때문에, 그 생성자에 대한 메뉴얼 대로 사용한것이다.
    // 밑줄이 잇는것은 디프리케이티드 떄문이다 버전 업그레이드 떄문에
    System.out.println(d2);

    // 1970년 1월 1일 0시 0분 0초부터 측정된 밀리초를 가지고 
    // 날짜 인스턴스(객체=메모리) 초기화시킨다.
    Date d3 = new Date(1000L * 60 * 60 * 24 * 365 * 50);
    System.out.println(d3);
  }
}














