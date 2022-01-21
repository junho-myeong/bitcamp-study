// 계산기 만들기 1단계 명령창 에서 계산기 실행하기
// java -cp bin/main com.eomcs.app1.App add 100 200
// 실행 결과 100 + 200 = 300
package com.eomcs.app1;

public class App {

  public static void main(String[] args) {
    // 한번에 하려 하지 말고 천천히 해간다.
    for (String arg : args) {
      System.out.println(arg);
    }
    // String안에 값을 비교할 때는 꼭 equals()를 써라!!!
    if (args[0].equals("add")) { // 내가 실수한곳 배웠는데도 실수함 !! 꼭 확인해보기
      int v1 = Integer.parseInt(args[1]);
      int v2 = Integer.parseInt(args[2]);
      System.out.printf("%d + %d = %d",v1, v2, v1 + v2);
    }
    //    System.out.println(args[0]);
    //    System.out.println(args[1]);
    //    System.out.println(args[2]);
    //    System.out.printf("%d + %d = %d",Integer.parseInt(args[1]), Integer.parseInt(args[2]) ,Integer.parseInt(args[1]) + Integer.parseInt(args[2]));
  }
}
