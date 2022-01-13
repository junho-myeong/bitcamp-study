package com.eomcs.oop.ex05.x1.upgrade5;

// 5) 계산기 기능 확장 방법5 - 의존 객체 주입 방식을 적용하여 기능 확장
// - 곱하기 계산 기능을 추가
// => 기존의 Calculrator 객체를 포함한 후 새 기능을 추가하기
public class CalculratorTest {
  public static void main(String[] args) {
    com.eomcs.oop.ex05.x1.Calculrator calculrator = new com.eomcs.oop.ex05.x1.Calculrator();
    Calculrator2 upgradeCalculrator = new Calculrator2(calculrator);
    // Calculrator2와 Calculrator 두개가 따로 만들어 진다

    upgradeCalculrator.plus(100);
    upgradeCalculrator.minus(200);
    upgradeCalculrator.multiple(2);
    System.out.println(upgradeCalculrator.getResult());
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











