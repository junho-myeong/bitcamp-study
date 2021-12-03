package com.eomcs.lang.ex04;

//# 배열 - 배열 레퍼런스와 null
//
public class Exam0551 {
  public static void main(String[] args) {

    int[] arr1;
    arr1 = new int[5];

    // 배열 레퍼런스를 초기화시키고 싶다면 null로 설정하라.
    // dangling pointer 가 발생할까봐 메모리 자체를 초기화 시키지는 못하고 레퍼런스를 초기화 시킬수잇다.
    arr1 = null; // 0으로 설정. 즉 레퍼런스가 아무것도 가리키지 않음을 의미. 내부적으론 0을 설정하는것이지만 null로 해줘야한다.

    // 레퍼런스가 배열 인스턴스를 가리키지 않은 상태에서 사용하려 하면?
    System.out.println(arr1[0]); // NullPointerException 실행 오류!
    // 주소를 잃어 버려 더이상 쓸수없는 메모리를 garbage 라고 부른다.
  }
}