package com.eomcs.app1;

public class CommandHandler {
  void doHelp() {
    System.out.println("App [명령] [값1] [값2]");
    System.out.println("add [값1] [값2] 더하기 기능을 수행한다. ex) App add 100 200");
    System.out.println("minus [값1] [값2] 빼기 기능을 수행한다. ex) App add 100 200");
  }

  void add(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("add 명령어 입력 형식이 올바르지 않습니다.");
      System.out.println("형식: add 값1 값2");
      System.out.println("예) add 100 200");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);;
      System.out.printf("%d + %d = %d \n", v1, v2 , v1 + v2);
    }
  }

  void minus(Command command) {
    if (command.getParamSize()!= 2) {
      System.out.println("minus 명령어 입력 형식이 옳지 않습니다.");
      System.out.println("형식:minus 값1 값2");
      System.out.println("예)minus 100 200");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%d - %d = %d \n", v1, v2 , v1 - v2);
    }
  }
}
