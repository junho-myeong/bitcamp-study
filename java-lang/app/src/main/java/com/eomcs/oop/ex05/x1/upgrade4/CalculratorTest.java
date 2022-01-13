package com.eomcs.oop.ex05.x1.upgrade4;

// 4) 계산기 기능 확장 방법4 - 포함 관계를 통한 기능 확장
// - 곱하기 계산 기능을 추가
// => 기존의 Calculrator 객체를 포함한 후 새 기능을 추가하기
public class CalculratorTest {
  public static void main(String[] args) {
    Calculrator2 c1 = new Calculrator2(); // Calculrator 객체를 내장하고 잇다. Calculrator2와 Calculrator의 생명 주지가 같다. 

    c1.plus(100);
    c1.minus(200);
    c1.multiple(2);
    System.out.println(c1.getResult());
  }
}

// 위임(delegation)
// - 상속은 문법 적으로 기능을 확장하기 때문에 코드가 경직 되어 있다.
// - 코드가 경직되어 있다?
//  => 다음과 같이 클래스가 계층을 이루고 있다고 가정하자.
//      A <-- B <-- C
//      즉 B는 A를 상속 받았고, C는 B를 상속 받는다.
//  => C의 기능이 필요한 D는 다음과 같이 C를 상속 받을것이다.
//      C <-- D
//  => 여기서 D는 B의 기능이 필요 없음에도 어쩔수 없이 상속 받아야한다.
//      왜? C가 B를 상속 받기 때문이다.
//      이것이 코드가 경직 되었다는 뜻이다.
//      필요 없는 기능을 자유롭게 뺄 수 없다. 즉 유연성이 부족하다.











