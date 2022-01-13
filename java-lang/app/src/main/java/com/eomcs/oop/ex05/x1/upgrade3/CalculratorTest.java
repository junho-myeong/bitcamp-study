package com.eomcs.oop.ex05.x1.upgrade3;

// 3) 계산기 기능 확장 방법3 - 상속 문법을 활용하여 기능 확장
// -곱하기 계산 기능을 추가
// => 상속 문법을 이용하여 기존 Calculrator 클래스와 연결한후 새기능 추가하기
public class CalculratorTest {
  public static void main(String[] args) {
    Calculrator2 c1 = new Calculrator2();

    c1.plus(100);
    c1.minus(200);
    c1.multiple(2);
    System.out.println(c1.result);
  }
}

// 상속(inheritance)
// 1) 특징:
//  - 기존 코드를 재사용할 수 잇다. 
//      => 같은 기능을 수행하는 코드를 재 작성할 필요가 없다.
//      => 코드 중복을 줄인다
//  - 기존 코드의 소스가 없어도 재사용할 수 잇다.
//      => 소스가 없는 기존 코드에 새 기능을 추가하거나 기존 기능을 변경하기 쉽다.
// 2) 단점
//  - 중간에 서브 클래스가 추가한 기능을 임의적으로 제거할 수 없다.
//  - 즉 서브 클래스를 계속 만들어 가다 보면 필요 없는 기능이 계속 누적 되는 문제가 발생한다.
//  
// 이러문제를 해결하기 위해 "위임" 방식을 사용한다.






