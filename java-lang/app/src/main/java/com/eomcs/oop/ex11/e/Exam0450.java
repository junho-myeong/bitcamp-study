// anonymous class - 익명 클래스가 놓이는 장소: 파라미터
package com.eomcs.oop.ex11.e;

class My {
  static void m1() {
    System.out.println("오호라!!");
  }

  void m2() {
    System.out.println("와우!");
  }
}

public class Exam0450 {
  // 인터페이스의 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  interface A {
    void print();
  }

  static A create1 () {
    class X implements A {
      @Override
      public void print() {
        System.out.println("hello1");
      }
    }
    return new X();
  }

  // 익명 클래스 사용한 예
  static A create2() {
    return new A() {
      @Override
      public void print() {
        System.out.println("hello2");
      }
    };
  }

  // 메서드 한개짜리 인터페이스 인터페이스 = 펑셔널 인터페이스
  // 람다 기법 사용 
  static A create3() {
    return () -> { System.out.println("hi3");};
  }

  // A인터페이스를 리턴해야하는데 여기서 이게 가능한 이유는?
  // My에 잇는 m1은 인터페이스 에 잇는 메서드랑 메서드 시그너쳐가 같기 때문이다.
  // 단, 추상 메서드가 하나일때만 가능하다
  static A create4() {
    return My::m1;
  }

  static A create5() {
    return new My()::m2;
  }

  public static void main(String[] args) {
    A obj1 = create1();
    obj1.print();
    A obj2 = create2();
    obj2.print();
    A obj3 = create3();
    obj3.print();

    A obj4 = create4();
    obj4.print();

    A obj5 = create5();
    obj5.print();


  }
}
