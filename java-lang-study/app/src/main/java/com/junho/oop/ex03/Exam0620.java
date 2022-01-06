// 스태틱 초기화 블록(static initializer) - 클래스 필드 사용
package com.junho.oop.ex03;

public class Exam0620 {
  public static class A {
    static int a;

    static void m() {

    }
    // 클래스가 로딩될 때 스태틱 초기화 블록은 실행된다.
    // 여러개의 스태틱 블록이 있을때, 컴파일러는 한개의 블록으로 합친다.
    // - 바이트 코드확인해보기

    static {
      System.out.println("Static{} 11111");
    }

    static {
      System.out.println("Static{} 22222");
    }
  }

  public static void main(String[] args) {

    // 클래스가 로딩되는 경우.
    // 1) 클래스멤버(필드와 메서드)를 사용할 때
    // 클래스가 로딩된 상태가 아니라면 클래스를 로딩한다.
    A.a = 100; // 클래스 필드를 사용하기 때문에 클래스가 로딩 된다.
    // 그리고 클래스가 로딩 되면 스태틱 블록이 실행된다.

    System.out.println("종료");

  }

}