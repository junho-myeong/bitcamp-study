package com.junho.oop.ex05.a;

public class Exam03 {
  public static void main(String[] args) {
    Score s = new Score();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 100;
    s.math = 100;
    s.compute();
    System.out.printf("%s: %d(%.1f)\n", s.name, s.sum, s.aver);

    Score s1 = new Score("김구", 80, 80, 80);
    System.out.printf("%s: %d(%.1f)\n", s1.name, s1.sum, s1.aver);
  }
}
