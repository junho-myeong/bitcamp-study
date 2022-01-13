// 메서드 오버로딩(overloading) - 응용 I
package com.eomcs.oop.ex06.b;

public class Exam0310 {
  public static void main(String[] args) {

    // 다양한 파라미터 값을 받는 println()
    // println도 오버로딩의 한 예이다.
    System.out.println(100);
    System.out.println(true);
    System.out.println("hello");

    // 외부에서 값을 받아 Integer 객체를 생성하는 메서드들
    // valueOf도 오버로딩의 예이다. 
    // 프로그램을 일관성 잇게 만들기 위해 사용하는 이유이다.
    Integer obj1 = Integer.valueOf(100);
    Integer obj2 = Integer.valueOf("100");
    Integer obj3 = Integer.valueOf("64", 16);

    System.out.printf("%d, %d, %d\n", obj1, obj2, obj3);

  }

}
