package com.junho.oop.ex05.h;

public class A {
  int v1;

  // A 클래스는 기본 생성자가 없다.
  // => int 값을 파라미터로 받는 생성자만 있다.
  A(int value) {
    super(); // Object클래스에 기본생성자를 호출 하는 명령어이다.
    this.v1 = value;
    System.out.println("A(int) 생성자 호출!!!");
  }
}
