package com.eomcs.app2.vo;

import java.io.Serializable;

public class Score implements Serializable{
  private static final long serialVersionUID = 1L;
  String name;
  int eng;
  int kor;
  int math;
  int sum; // getter만 필요하다 조회용으로만 사용
  float aver;

  public static Score fromCSV(String csv) {
    String[] values = csv.split(",");
    Score score = new Score();
    score.setName(values[0]);
    score.setKor(Integer.parseInt(values[1]));
    score.setEng(Integer.parseInt(values[2]));
    score.setMath(Integer.parseInt(values[3]));
    return score;
  }
  public String toCSV() {
    return String.format("%s,%d,%d,%d",
        this.getName(),
        this.getKor(),
        this.getEng(),
        this.getMath());
  }

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
    compute();
  }
  public int getKor() {
    return kor;
  }
  public void setKor(int kor) {
    this.kor = kor;
    compute();
  }
  public int getMath() {
    return math;
  }
  public void setMath(int math) {
    this.math = math;
    compute();// 입력할때마다 다시 계산하는것이다.
  }
  public int getSum() {
    return sum;
  }
  public float getAver() {
    return aver;
  }

  @Override
  public String toString() {
    return "Score [name=" + name + ", eng=" + eng + ", kor=" + kor + ", math=" + math + ", sum="
        + sum + ", aver=" + aver + "]";
  }


}
