package com.junho.oop.ex05.d;

public class Exam02 {

  public static void main(String[] args) {
    Score2 s = new Score2();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 100;
    s.math = 100;
    s.music = 90;
    s.art = 80;
    s.compute();

    System.out.printf("%s: %d(%.1f)\n", s.name, s.sum, s.aver);

  }

}
