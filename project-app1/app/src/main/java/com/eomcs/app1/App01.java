package com.eomcs.app1;

public class App01 {

  public static void main(String[] args) {

    Console console = new Console();
    CommandHandler commandHandler = new CommandHandler();

    while (true) {
      Command command = console.prompt();
      try { // 예외가 발생할 가능 성이 잇는 코드는 try 블럭 안에 가둔다.
        if (command.getName().equals("quit") || command.getName().equals("exit")) {
          break;

        } else if (command.getName().equals("")) {
          continue;

        } else if (command.getName().equals("help")) {
          commandHandler.doHelp();

        } else if (command.getName().equals("add")) {
          commandHandler.doAdd(command);

        } else if (command.getName().equals("minus")) {
          commandHandler.doMinus(command);

        } else if (command.getName().equals("divide")) {
          // 예외 처리 후에는 JVM의 작동이 중단되지 않는다.
          // 예외처리: 시스템 처리중 예외가 발생하더라도 시스템을 중단시키지 않고 계속 실행하게 도와주는 문법이다.
          commandHandler.doDivide(command);

        } else {
          System.out.println("지원하지 않는 연산자입니다.");
        }
      } catch (Exception e) { // try블록에서 발생한 예외는 이곳에서 잡는다.
        // 예외에 대한 적절한 조치를 취한 코드를 이곳에 둔다.
        System.out.println("명령어 처리중 오류 발생!");
      }
    }
    console.close();
  }

}







