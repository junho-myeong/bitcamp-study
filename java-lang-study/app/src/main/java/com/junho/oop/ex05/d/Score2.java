package com.junho.oop.ex05.d;

public class Score2 extends Score{
  public int music;
  public int art;

  // 기존 코드를 변경한다 => 기존의 메서드 재 정의 = > overriding
  // 오버라이딩?
  // => 오버라이딩이란 super class에 메서드를 상속 받아서
  //    현재 프로젝트에 맞는 기능을 추가하기 위해
  //    메서드를 재정의 하는 것을 말한다.
  // 오버라이딩 사용법?
  // => 오버라이딩을 하기 위해서는 
  //    메서드 시그너처(메서드명, 파라미터, 리턴타입)가 같아야한다
  @Override
  public void compute() {
    this.sum = this.kor + this.eng + this.math + this.music + this.art;
    this.aver = this.sum / 5f;
  }
}
