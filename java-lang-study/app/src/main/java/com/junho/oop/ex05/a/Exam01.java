// 상속 - 사용하기 전
package com.junho.oop.ex05.a;

public class Exam01 {
  public static void main(String[] args) {
    // Default method로 instance filed 초기화 시키기

    Car c1 = new Car(); // 생성자 함수의 호출을 통해 인스턴스 만들기
    c1.maker = "현대 자동차";
    c1.model = "제네시스";
    c1.capacity = 5;
    System.out.printf("제조자: %s, 모델명: %s, 수용인원: %d\n", c1.maker, c1.model, c1.capacity);
    Car c2 = new Car("현대자동차1", "제네시스1", 100); // 생성자를 통해 인스턴스 만들고 
    // 생성자를 사용하는 이유중에 하나는 초기 인스턴스 필드를 초기화 하기 위해서 이다.
    System.out.printf("제조자: %s, 모델명: %s, 수용인원: %d", c2.maker, c2.model, c2.capacity);
    Car.run();
  }


}
