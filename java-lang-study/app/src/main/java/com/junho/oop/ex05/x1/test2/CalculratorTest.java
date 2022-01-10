package com.junho.oop.ex05.x1.test2;

public class CalculratorTest {

  public static void main(String[] args) {
    com.junho.oop.ex05.x1.test1.Calculrator c1 = new com.junho.oop.ex05.x1.test1.Calculrator();

    c1.plus(100);
    c1.minus(200);
    c1.mutiple(2);

    System.out.println(c1.result);
  }
}

// 새 기능을 추가하기 위해 기존 코드를 변경하는 방식의 문제점:
// 1) 새 기능을 추가하거나 변경하면서 기존의 코드를 손대는 경우, 없던 오류가 발생할 수 있다.
// 2) 기존 코드에 계속 코드를 추가 하다 보면 코드의 덩치가 커지고 복잡해져서 유지 보수가 어려워 진다.
// 3) 새로 추가한 기능이나 변경한 기능이 다른프로젝트에서 필요 없을 때 기존 코드에서 제거하기 힘들다.
//  => 왜? 이전에 만든 프로젝트에서 그 기능을 사용하고 잇다면 코드를 제거 할수 없기 때문이다.
// 4) 기존 소스가 없으면 이 방식을 사용할 수 없다.
//
// 이런문제점을 해결하기 위해 나온 문법이 "상속(inheritacne)"이다.