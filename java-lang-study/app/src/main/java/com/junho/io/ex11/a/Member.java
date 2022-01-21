package com.junho.io.ex11.a;

// 이클래스는 따로 기능을 가진 클래스가 아니고 사용자 정의 데이터 타입을 위한 클래스이다.
public class Member {
  String name;
  int age;
  boolean gender; // true(여자), false(남자)
  @Override
  public String toString() {
    return "Member [name=" + name + ", age=" + age + ", gender=" + gender + "]";
  }

}
