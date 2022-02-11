// static nested class : 클래스 정의와 인스턴스 생성
package com.eomcs.oop.ex11.b;

// import를 사용하면 스태틱 중첩 클래스를 패키지 맴버 클래스처럼 사용가능

class A {
  static class X {

  }
}

public class Exam0110 {

  public static void main(String[] args) {
    // 레퍼런스 선언
    // 스태틱 클래스도 스태틱 메서드와 변수 처럼 클래스 이름으로 선언하면 된다.
    A.X obj;

    // 인스턴스 생성
    obj = new A.X();
  }

}
