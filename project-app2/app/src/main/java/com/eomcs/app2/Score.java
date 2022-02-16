package com.eomcs.app2;

public class Score {
  String name;
  int eng;
  int kor;
  int math;
  int sum; // getter만 필요하다 조회용으로만 사용
  float aver;

  private void compute() {
    this.sum = this.kor + this.math + this.eng;
    this.aver = this.sum / 3f;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getEng() {
    return eng;
  }
  public void setEng(int eng) {
    this.eng = eng;
  }
  public int getKor() {
    return kor;
  }
  public void setKor(int kor) {
    this.kor = kor;
  }
  public int getMath() {
    return math;
  }
  public void setMath(int math) {
    this.math = math;
  }
  public int getSum() {
    return sum;
  }
  public float getAver() {
    return aver;
  }


}
