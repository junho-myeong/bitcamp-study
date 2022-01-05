// 변수 자동 초기화 - 스태틱 변수(클래스 변수)
package com.junho.oop.ex03;

import java.sql.Date;

public class Exam0510 {
  static class A {
    // 전부 클래스 변수로 변수 선언이 되어있는 상태이다.
    static byte b;
    static short s;
    static int i;
    static long l;
    static char c;
    static float f;
    static double d;
    static boolean bool;
    static String str;
    static Date date;
  }

  public static void main(String[] args) {
    // 클래스 변수(스태틱 변수)는 생성되는 순간 0으로 자동 초기화 된다.
    // 여기서 생성되는 순간이란 클래스가 처음으로 Method Area에 올려 졌을때를 말한다.
    // => 정수(byte, short, int, long, char) : 0
    // => 부동소수점(float, double) : 0.0 = 0
    // => 논리(boolean) : false = 0
    // => 레퍼런스: null = 0
    //
    System.out.printf("%d, %d, %d, %d, %c, %.1f, %.1f, %b, %s, %s\n", 
        A.b, A.s, A.i, A.l, A.c, A.f, A.d, A.bool, A.str, A.date);

    // 로벌 변수는 자동으로 초기화되지 않는다.
    // 사용하기 전에 반드시 초기화시켜야 한다.
    // 다음과 같이 초기화 시키지 않은 상태에서 사용하면 컴파일 오류가 발생한다.
    // int x;
    // System.out.println(x); // 컴파일 오류
    // 변수할당과 변수 초기화는 다른것이다.
    // 1) 변수할당은 우리가 사용할 변수에 대한 메모리를 준비하는 단계이고
    // 2) 변수 초기화는 그 메모리에 우리가 넣고 싶은 값을 넣는것을 말한다.
  }

}
