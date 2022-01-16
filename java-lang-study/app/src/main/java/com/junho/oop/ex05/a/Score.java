package com.junho.oop.ex05.a;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = sum/3f; 
  }
  public Score() {

  }
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
