package com.eomcs.oop.ex01;

public class ExamTest10 {
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }


  public static void main(String[] args) {
    Score s = createScore("홍길동", 100, 100, 100);
    printScore(s);


  }
  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
  static Score createScore(String name, int kor, int eng, int math) {
    Score s = new Score();
    s.name = name;
    s.eng = eng;
    s.math = math;
    s.kor = kor;
    s.sum = s.eng + s.kor + s.math;
    s.aver = s.sum /3f;
    return s;
  }

}
