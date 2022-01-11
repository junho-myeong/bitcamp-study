// 기존의 클래스를 손대지 않고 새 기능만 추가한다.
// 어떻게? 상속 문법을 이용한다.
package com.eomcs.oop.ex05.d;

public class Score2 extends Score {

  // 새 필드를 추가한다.
  public int music;
  public int art;


  // 기존 코드를 변경한다. => 기존의 메서드 재정의 => 오버라이딩(overriding)
  // 오버라이딩은 메스드 시그너처가 같아야한다(메서드명, 파라미터, 리턴타입)이 같아야한다.
  @Override
  public void compute() {
    this.sum = this.kor + this.eng + this.math + this.music + this.art;
    this.aver = this.sum / 5f;
  }
}







