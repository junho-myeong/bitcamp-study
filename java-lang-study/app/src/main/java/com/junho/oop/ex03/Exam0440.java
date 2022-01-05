// 생성자 - this()
package com.junho.oop.ex03;

public class Exam0440 {
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

    Score() {
      // 생성자 내에서 다른 생성자를 호출할때
      // 다른 생성자를 호출할 때는 this()를 사용한다.
      // 단, 생성자의 첫 문장으로 와야 한다.
      this("이름없음");  // 문자열 하나를 받는 생성자를 호출하라는 뜻이다.
      // Score(String) 생성자 호출, this하고 생성자중에 문자열을 받는 
      // 생성자를 찾는다
      // 여기서 this는 다른 생성자를 가르키는것이다.

      System.out.println("Score()");
    }

    Score(String name) {
      // 다른 생성자를 호출할 때는 this()를 사용한다.
      // 단, 생성자의 첫 문장으로 와야 한다.
      this(name, 0, 0, 0); // Score(String, int, int, int) 생성자 호출
      // 여기서는 파라미터를 네개를 받는 생성자를 찾는다.

      System.out.println("Score(String)");
    } // 이함수가 끝나고 그 값을 위에 생성자에 리턴한다.

    Score(String name, int kor, int eng, int math) {
      System.out.println("Score(String,int,int,int) 호출!");
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.compute();
    } // 이함수가 끝나고 그 값을 위에 생성자에 리턴한다.

    public void compute() {
      // this("오호라~~") // 일반 메서드에서는 생성자를 호출할 수 없다!!, 즉 생
      this.sum = this.kor + this.eng + this.math;
      this.average = this.sum / 3f;
    }
  }
  public static void main(String[] args) {
    Score s1 = new Score();

    Score s2 = new Score("유관순");

    Score s3 = new Score("김구", 100, 100, 100);

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum,
        s1.average);

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s2.name, s2.kor, s2.eng, s2.math, s2.sum,
        s2.average);

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s3.name, s3.kor, s3.eng, s3.math, s3.sum,
        s3.average);

  }
}
