package com.eomcs.oop.ex02;

public class ExamTest11 {
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    void calculator() {
      this.sum = this.eng + this.kor +this.math;
      this.aver = this.sum/3f;
    }
  }
  public static void main(String[] args) {
    Score s = new Score();
    s.name = "홍길동";
    s.eng = 100;
    s.kor =80;
    s.math = 100;
    s.calculator();

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}




