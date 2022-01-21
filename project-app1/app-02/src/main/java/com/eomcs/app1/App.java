// 계산기 만들기 2단계 - 도움말 기능 추가하기
// java -cp bin/main com.eomcs.app1.App
//
package com.eomcs.app1;

public class App {

  public static void main(String[] args) {
    // argument가 없으면 빈배열을 리턴해준다.
    if (args.length == 0) {
      System.out.println("사용법 :");
      System.out.println("App [명령] [값1] [값2]");
      System.out.println("명령");
      System.out.println("add [값1] [값2] 더하기 기능을 수행한다. ex) App add 100 200");
      System.out.println("minus [값1] [값2] 빼기 기능을 수행한다. ex) App add 100 200");
    } else {
      int v1 = Integer.parseInt(args[1]);
      int v2 = Integer.parseInt(args[2]);
      if (args[0].equals("add")) {
        System.out.printf("%d + %d = %d", v1, v2, v1 + v2);
      } else if (args[0].equals("minus")) {
        System.out.printf("%d - %d = %d", v1, v2, v1 - v2);
      }
    }

  }
}