// Wrapper 클래스 - 오토박싱(auto-boxing)/오토언박싱(auto-unboxing)
package com.junho.basic.ex02;

public class Exam0223 {

  public static void main(String[] args) {
    int i1 = 100;
    Integer obj = Integer.valueOf(200);

    printInt(obj);
    // 컴파일러가 printInt(obj.intValue())로 바꾼다.
    // 즉 "오토 언박싱"을 수행한다.

    printObject(100);
    // 컴파일러가 printObject(Integer.valueOf(100)) 으로 바꾼다.
    // 즉 "오토 박싱"을 수행한다.
  }

  static void printInt(int value) {
    System.out.println(value);
  }

  static void printObject(Integer obj) {
    System.out.println(obj.toString());
    // toString 을 빼도 값이 나온다. 왜냐면 Wrapper 클래스는 toString을 오버라이딩 했기때문에
  }

}
