package com.eomcs.lang.ex04;

//# 형변환 - 명시적 형변환이 불가능한 경우, 특별한 메서드를 사용하면 가능하다. 
// 
public class Exam0951 {
  public static void main(String[] args) {

    byte b = Byte.valueOf("100");
    short s = Short.valueOf("32767");
    int i1 = Integer.valueOf("2122223333");
    int i2 = Integer.parseInt("2122223333");
    long l = Long.valueOf("912345672123");
    float f1 = Float.valueOf("3.14f"); //문자열 => 부동소수점
    float f2 = Float.parseFloat("3.14f"); //문자열 => 부동소수점
    double d1 = Double.valueOf("9876.54321");
    double d2 = Double.parseDouble("9876.54321");
    boolean bool1 = Boolean.valueOf("true");
    boolean bool2 = Boolean.parseBoolean("1"); // java는 1은 못바꾼다!! , 단 springboot는 1도 true로 바꿔준다
    char c = "가".charAt(0);
    System.out.println(b);
    System.out.println(s);
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(l);
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(d1);
    System.out.println(d2);
    System.out.println(bool1);
    System.out.println(bool2);
    System.out.println(c);


    boolean v1 = Boolean.valueOf("true"); // 문자열 => boolean

    char v2 = "가".charAt(0); //문자열 => char

    int v3 = Integer.valueOf("123"); //문자열 => int
    int v33 = Integer.parseInt("123");// 문자열 => int


    System.out.println(v1);
    System.out.println(v2);
    System.out.println(v3);
    System.out.println(v33);
  }
}
