package com.eomcs.oop.ex02;

public class ExamTest1 {
  // 사용자 정의 데이터 타입 을 하는 class 이다
  static class Score {
    // 변수 선언
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

    // 메서드 정의: 선언된 변수 또는 필드를 사용해서 기능을 수행하는 함수를 만든다.
    // staitc 메서드 정의(클래스 메서드): 클래스 내부에서 사용하는 메서드이다.,즉 클래스에 직접 접근해서 사용하는것, 주소를 파라미터로 받는다.
    static void calculate(Score score) {
      score.sum = score.kor + score.eng + score.math;
      score.average = score.sum / 3f;
    }
    // 메서드 정의: 선언된 변수 또는 필드를 사용해서 기능을 수행하는 함수를 만든다.
    // non-static메서드(인스턴스 메서드) : 인스턴스에 복재본으로 사용하는 메서드 이기 때문에 주소를 줘서 접근 해야한다., 단 주소를 받을때 앞에서 받는다.
    void calculate1() {
      this.sum = this.kor + this.eng + this.math;
      this.average = this.sum / 3f;
    }
  }

  public static void main(String[] args) {

    Score score = new Score();
    Score score1 = new Score();

    score.name = "홍길동"; 
    score.kor = 100;
    score.eng = 90;
    score.math = 85;
    Score.calculate(score);


    score1.name = "홍길동"; 
    score1.kor = 100;
    score1.eng = 90;
    score1.math = 85;
    score1.calculate1();

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", score.name, score.kor, score.eng, score.math,
        score.sum, score.average);

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", score1.name, score1.kor, score1.eng, score1.math,
        score1.sum, score1.average);
  }
}



