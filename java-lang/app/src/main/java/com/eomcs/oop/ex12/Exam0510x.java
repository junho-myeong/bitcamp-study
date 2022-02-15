// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;


public class Exam0510x {

  static class MyCalculator {
    public static int plus(int a, int b) {return a + b;}
    public static int minus(int a, int b) {return a - b;}
    public static int multiple(int a, int b) {return a * b;}
    public static int divide(int a, int b) {return a / b;}
  }

  interface Calculator {
    int compute(int x, int y);
  }

  public static void main(String[] args) {
    // 아래로 내려가면서 우리가 더쉽게 하기 위한것이지 어차피 컴파일하면,
    // 컴파일러가 같은 코드로 바꿔준다
    // 1) 로컬 클래스로 사용하기
    class CalculatorImpl implements Calculator {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    }
    Calculator c1 = new CalculatorImpl();
    System.out.println(c1.compute(100, 200));

    // 2) 익명 클래스로 사용하기
    Calculator c2 = new Calculator() {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    };
    System.out.println(c2.compute(100, 200));

    // 3) 람다 메서드 활용하기
    Calculator c3 = (x, y) ->  MyCalculator.plus(x, y);
    System.out.println(c3.compute(100, 200));

    // 4) 메서드 레퍼런스 사용하기
    Calculator c4 = MyCalculator::plus;
    System.out.println(c4.compute(100, 200));
  }
}


