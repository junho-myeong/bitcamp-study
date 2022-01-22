// Object 클래스의 메서드를 오버라이딩 하기 - toString()
package com.junho.basic.ex01;

public class Exam0122 {

  // super class를 지정하지 않으면 기본으로 java.lang.Object 클래스가
  // super class로 지정된다.

  static class Score /* extends Object*/ { // 지정하지 않으면 자동으로 object 상속받는다
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    // 생성자 함수를 만드는 코드, 생성자 함수를 만드는 이유는 
    // 인스턴스를 생성할 때 필드값을 초기화 하기 위해 만든다.
    public Score(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.sum = this.kor + this.eng + this.math;
      this.aver = this.sum / 3f;
    }
  }

  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 100, 100);

    String str = s1.toString();
    // toString()?
    // => Score 클래스의 슈퍼 클래스인 Object의 메서드이다.
    // => 클래스를 정의할 때 슈퍼 클래스를 지정하지 않으면,
    //  자동으로 java.lang.Object 클래스가 슈퍼 클래스로 지정된다.
    // => 그래서 자바의 모든 클래스는 toString()을 호출할 수 있다.
    //  즉 자바의 모든 클래시는 Object 클래스에 정의된 메서드를 호출할 수 있다.

    System.out.println(str); // 오버라이딩 하지 않아서 Object에 toString()이 호출되서
    // 클래의 기본 정보가 출력된다.

    // toString()의 리턴 값?
    // => Object의 toString()을 호출하면 다음 형식의 문자열을 리턴한다. 
    //       "패키지 이름을 포함한 클래스명@인스턴스 식별자(해시코드)"
    // 예) com.eomcs.oop.ex06.d.Exam0122$Score@12a74311
    //
    // 인스턴스 식별자?
    // => 인스턴스의 주소가 아니다. 자바는 절대로 메모리 주소를 알려주지 않는다!
    // => 단지 인스턴스를 식별할 때 사용하라고 JVM이 임의로 붙인 식별자이다.
    // => 이 식별자를 "해시값(hashcode)"라 부른다.
    // 

  }

}
