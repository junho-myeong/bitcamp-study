package com.junho.oop.ex05.x1.test3;

public class CalculratorTest {

  public static void main(String[] args) {
    Calculrator2 c1 = new Calculrator2();

    c1.plus(100);
    c1.minus(200);
    c1.mutiple(2);

    System.out.println(c1.result);
  }
}

// 기존 코드를 복제한후 기능을 추가하는 방식의 문제점:
// 1) 같은 코드가 여러 클래스에 중복 된다.
//  => 코드 변경할 때 원본을 복제해서 만든 모든 소스도 변경해야 하는 번거로움이 있다.
//  => 예1) 원본 클래스에서 버그가 발견 되었을 때.
//          그 클래스를 복제해서 만든 모든 클래스에도 버그가 존재하기 때문에
//          원본 클래스 뿐만 아니라 복제한 클래스 모두에 대해서도 코드를 수정해야한다.
//  => 예2) 기존 기능을 변경할때,
//          그 클래스를 복제해서 만든 모든 클래스에 코드도 변경해야한다.
//
// 이런문제점을 해결하기 위해 나온 문법이 "상속(inheritance)"이다.