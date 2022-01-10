package com.junho.oop.ex05.x1.test4;

// 상속으로 기능을 확장하는 방법은 extends 를 사용해서 기존의 사용해야 하는 메서드 들의
// 집합이 잇는 클래스를 알려줘야한다.
public class Calculrator2 extends com.junho.oop.ex05.x1.test1.Calculrator{

  //Calculrator 클래스에 잇는 코드를 마치 자신의 코드인것 처럼 사용하겠다는 의미!!1
  public void mutiple(int value) {
    this.result *=value;
  }
} 
