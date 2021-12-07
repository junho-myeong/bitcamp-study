package com.eomcs.lang.ex04;

//# 값 저장과 메모리 크기 - 작은크기의 메모리 값을 큰 크기의 메모리에 저장할 수 있다.
//
public class Exam0910 {
  public static void main(String[] args) {

    byte b = 100; //1byte
    short v1 = b; //1byte ==> 2byte

    short s = 100;
    int v2 = s; //2byte ==> 4byte

    int i = 98765678;
    long v4 = i; //4byte ==>8byte

    long l = 98765678; // 8byte

    char c = 100; // 2byte
    //  short x1 = c; // 조심!! char(양의 정수만 저장하는 2byte이다, 0~65535) ==> short(-32768~32767) , 값의 범위가 맞지 컴파일 오류    
  }
}

// 정리!
// - 정수 메모리의 값(byte, short, char, int, long)을 
//   부동소수점 메모리(float, double)에 저장할 때
//   주의해서 사용하라!
// - 유효자릿수를 넘어가는 정수 값인 경우 부동소수점 메모리에 저장될 때 짤릴 수 있다.
//   그럼에도 컴파일 오류가 발생하지 않기 때문에
//   개발자들이 놓치는 경우가 많다!