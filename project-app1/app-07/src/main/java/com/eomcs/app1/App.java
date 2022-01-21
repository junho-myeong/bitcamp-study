// 계산기 만들기 2단계 - 메서드 분리하는 용도로 클래스 사용하기!
// java -cp bin/main com.eomcs.app1.App
//
package com.eomcs.app1;

public class App {

  /* main()*/
  public static void main(String[] args) {
    System.out.println("도움말 이 필요 하시면 help를 입력해주세요!");
    CommandHandler commandHandler = new CommandHandler(); 
    Consol consol = new Consol();
    while (true) {
      Command command = consol.prompt(); // 스태틱 메서드 활용
      if (command.getName().equals("quit")|| command.getName().equals("exit")) {
        break;
      } else if(command.getName().equals(""))  {
        continue;
      } else if (command.getName().equals("help")) {
        commandHandler.doHelp();
      } else  if (command.getName().equals("add")) {
        commandHandler.add(command);
      } else if (command.getName().equals("minus")) {
        commandHandler.minus(command);
      } else {
        System.out.println("지원하지 않는 연산자입니다.");
      }
    } 
    consol.close();
  } /*main()*/







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
