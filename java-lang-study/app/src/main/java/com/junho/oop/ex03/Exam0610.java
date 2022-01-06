// 스태틱 초기화 블록(static initializer) - 레퍼런스 선언
package com.junho.oop.ex03;

public class Exam0610 {
  public static class A {
    static int a;

    static void m() {

    }

    // 클래스 로딩된 후
    // 1) 클래스 필드를 만든다(Method Area)에
    // 2) 스태틱 블록을 실행한다.

    // 컴파일할 때
    // - 여러 개의 스태틱 블록이 있으면 컴파일러는 한 개의 블록으로 합친다.
    // - 스태틱 블록의 위치에 상관없이 작성된 순서대로 한 개의 static 블록으로 합친다.
    // - 바이트코드 확인해 보라.

    static {
      System.out.println("Static{} 11111");
    }
    static {
      System.out.println("Static() 2222");
    }
  }

  public static void main(String[] args) {
    // 클래스가 로딩되는 경우.
    // 1) 클래스멤버(클래스 필드,클래스 메서드)사용할때(클래스 이름으로 접근해서 사용한다.)
    // 2) 인스턴스를 생성할때(new 명령을 실행할때)

    // 주의!
    // - 각각의 클래스는 딱 한 번만 로딩된다.
    // - 레퍼런스를 선언할 때는 클래스가 로딩되지 않는다.
    // - 그래서 스태틱 초기화 블록이 실행되지 않는다.
    A obj1;
    A obj2;

    System.out.println("종료");

  }

}