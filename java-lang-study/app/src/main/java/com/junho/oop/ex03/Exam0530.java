// 변수 자동 초기화 - 로컬 변수
package com.junho.oop.ex03;

public class Exam0530 {

  public static void main(String[] args) {
    // 로컬 변수는 자동으로 초기화 되지 않는다.
    // 반드시 변수를 사용하기 전에 초기화 시켜야한다.
    // 초기화 하지 않은 로컬 변수는 사용할수 없다.
    // 초기화란?
    // - 변수에 값을 한번이라도 저장하는 것을 의미한다.
    int x;
    char y;
    boolean z;
    float a;
    String s;

    // 다음과 같이 변수를 한번도 초기화 하지 않은 로컬변수를 사용하려고 하면 컴파일 오류가 발생한다.
    //    System.out.println(x);
    //    System.out.println(y);
    //    System.out.println(z);
    //    System.out.println(a);
    //    System.out.println(s);

  }

}
