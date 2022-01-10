// 위임 기법을 이용하여 기능추가
// 포함관계로 연결하여 기능을 추가한다.
package com.junho.oop.ex05.x1.test5;

import com.junho.oop.ex05.x1.test1.Calculrator;

// 기존의 방식과 비슷하지만 다른 점이 잇다.
public class Calculrator2 {
  Calculrator origin = new Calculrator();
  // plus(), minu()는 기존의 Calculrator 클래스에게 위임한다.

  public void plus(int value) {
    // 이 클래스가 포함하고 있는 객체에게 실행을 위임한다.
    origin.plus(value);
  }

  public void minus(int value) {
    origin.minus(value);
  }

  // 새 기능 또한 기존 객체의 필드를 사용하여 처리한다.
  public void mutiple(int value) {
    origin.result *=value;
  }

  // 다른 클래스에 잇는 필드를 사용하기 때문에 getter 메스드로 가져와야한다.
  public int getResult() {
    return origin.result;
  }
} 
