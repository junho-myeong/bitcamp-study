// 계산기 만들기 2단계 - 도움말 기능 추가하기
// java -cp bin/main com.eomcs.app1.App
//
package com.eomcs.app1;

import java.util.Scanner;

public class App {
  static Scanner sc = new Scanner(System.in);
  /* main()*/
  public static void main(String[] args) {
    System.out.println("도움말 이 필요 하시면 help를 입력해주세요!");
    while (true) {
      String input = prompt();
      if (input.equals("quit")|| input.equals("exit")) {
        break;
      } else if(input.length() ==0)  {
        continue;
      } else if (input.equals("help")) {
        doHelp();
      } else {
        String[] values = input.split(" ");
        if (values[0].equals("add")) {
          add(values);
        } else if (values[0].equals("minus")) {
          minus(values);
        } else {
          System.out.println("지원하지 않는 연산자입니다.");
        }
      }
    } 

  } /*main()*/
  static String prompt() {
    System.out.print(">");
    return sc.nextLine();
  }
  static void doHelp() {
    System.out.println("App [명령] [값1] [값2]");
    System.out.println("add [값1] [값2] 더하기 기능을 수행한다. ex) App add 100 200");
    System.out.println("minus [값1] [값2] 빼기 기능을 수행한다. ex) App add 100 200");
  }
  static void add(String[] values) {
    if (values.length != 3) {
      System.out.println("add 명령어 입력 형식이 올바르지 않습니다.");
      System.out.println("형식: add 값1 값2");
      System.out.println("예) add 100 200");
    } else {
      int v1 = Integer.parseInt(values[1]);
      int v2 = Integer.parseInt(values[2]);
      System.out.printf("%d + %d = %d \n", v1, v2 , v1 + v2);
    }
  }
  static void minus(String[] values) {
    if (values.length != 3) {
      System.out.println("minus 명령어 입력 형식이 옳지 않습니다.");
      System.out.println("형식:minus 값1 값2");
      System.out.println("예)minus 100 200");
    } else {
      int v1 = Integer.parseInt(values[1]);
      int v2 = Integer.parseInt(values[2]);
      System.out.printf("%d - %d = %d \n", v1, v2 , v1 - v2);
    }
  }
}

/* 내 방법 (내 방법에 문제점 파악하고 강사님은 어떻게 변환 했는지 보기)
String[] input = {sc.next(), sc.next() ,sc.next()};
if (input[0].equals("help")) {
  System.out.println("사용법 :");
  System.out.println("App [명령] [값1] [값2]");
  System.out.println("명령");
  System.out.println("add [값1] [값2] 더하기 기능을 수행한다. ex) App add 100 200");
  System.out.println("minus [값1] [값2] 빼기 기능을 수행한다. ex) App add 100 200");
} else if (input[0].equals("add")){
  if (Integer.parseInt(input[2]) == 0) {
    System.out.println("명령어 형식이 옳지 않습니다.");
  } else {
    System.out.printf("%d + %d = %d", Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[1])+ Integer.parseInt(input[2]));
  } 
}
else if (input[0].equals("multiple")) {
  System.out.println("지원하지 않는 연산자 입니다.");
} else {
  break;
}
 */
