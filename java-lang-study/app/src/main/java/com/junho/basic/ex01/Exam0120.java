// Object 클래스 - toString() 메서드에 대하여
package com.junho.basic.ex01;

public class Exam0120 {
  static class My {

  }

  public static void main(String[] args) {

    My obj = new My();

    //Object에서 상속 받은 메서드
    //
    // 1) toString()
    //  - 클래스 정보를 간다히 출력한다.
    //  - 패키지명.클래스명@16진수해시값
    //  - 예) com.junho.basic.ex01.Exam0120$My@6ce253f1
    //
    System.out.println(obj.toString());

    // println()에 넘겨 주는 값이 String 타입이 아니라면
    // println()은 그 객체에 대해 toString() 호출한 후 그 리턴값을 출력한다.
    // 따라서 다음 코드는 위의 코드와 같다.
    System.out.println(obj);

    My obj2 = new My();
    My obj3 = new My();
    System.out.println(obj2 == obj3);
    System.out.println(obj2.equals(obj3));

    System.out.println(obj2.toString());
    System.out.println(obj3.toString());
  }

}
