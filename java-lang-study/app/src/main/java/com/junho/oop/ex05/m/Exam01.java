// 상속 - 추상클래스
package com.junho.oop.ex05.m;

// Car 클래스는 Sedan과 Truck의 공통 기능을 관리하기 위해 만든 클래스이다.
// 즉 Car 클래스는 직접 인스턴스를 만들어 사용하기 위해서 정의한 클래스가 아니다.
// Sedan과 Truck에서 겹치는 코드를 공통 관리하기 위해 만든 클래스이다.
// 가능한 직접 Car 클래스를 사용하는것을 피해야 한다.


public class Exam01 {

  public static void main(String[] args) {
    // Car 클래스를 직접 사용하는것을 막기위해 나온 문법이 잇다.
    // 그것이 바로 추상클래스이다.
    // => 만약 추상 클래스의 인스턴스를 만들려고 한다면 컴파일 오류가 발생한다.
    // Car c = new Car(); // 컴파일 오류가 발생한다.


    // Generalization 과정에서 정의한 슈퍼 클래슬에 대해
    // 직접 사용하지 못하도록 추상클래스로 선언한다.

    Sedan s = new Sedan();
    Truck t = new Truck();
    s.run();
    t.run();


  }

}
