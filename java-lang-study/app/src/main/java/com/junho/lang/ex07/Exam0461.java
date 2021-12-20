package com.junho.lang.ex07;

//# 메서드 : 스택 오버플로우 오류!
//
public class Exam0461 {

  static long sum(int value1, int value2, int value3, int value4) {
    if (value1 == 1)
      return 1;

    long v1 = value1 + 10L;
    long v2 = value2 + 10L;
    long v3 = value3 + 10L;
    long v4 = value4 + 10L;

    System.out.println(v1);


    return value1 + sum(value1 - 1,value2, value3, value4);
  }

  public static void main(String[] args) {
    // 호출하는 메서드의 로컬 변수 메모리가 많을 때 스택 메모리가 빨리 찬다.
    // => 즉 스택 오버플로우는 메서드 호출 회수에 영향을 받는 것이 아니라,
    //    메서드에서 생성하는 로컬 변수의 크기에 영향을 받는다. (한번 호출할때 사용 하는게 int long 여러개가 잇으면 더 빨리찬다)
    // 
    System.out.println(sum(5000,1000,2000,3000));
  }
}





