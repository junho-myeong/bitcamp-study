package com.eomcs.app1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Worker extends Thread {

  Socket socket;

  public Worker(Socket socket) {
    this.socket = socket;
  }
  @Override
  public void run() {
    try {
      // 클라이언트와 데이터를 주고 받을 입출력 도구를 준비한다.
      Scanner in = new Scanner(socket.getInputStream());
      PrintStream out = new PrintStream(socket.getOutputStream());

      String queryString = in.nextLine();
      String[] values = queryString.split("/");

      if (values.length != 3) {
        System.out.println("천재명준호가 보냄! 계산식이 올바르지 않습니다.");
      } else {
        String op = values[0];
        if (op.equals("%2f")) {
          op = "/"; // %2f문자열을 원래의 문자인 / 로 디코딩 한다.
        }
        int a = Integer.parseInt(values[1]);
        int b = Integer.parseInt(values[2]);
        int result = 0;
        switch (op) {
          case "+": 
            result = a + b; 
            out.printf("천재명준호가 보냄!%d %s %d = %d\n", a, op, b, result);
            break;
          case "-": 
            result = a - b;
            out.printf("천재명준호가 보냄! %d %s %d = %d\n", a, op, b, result);
            break;
          case "/":
            result = a / b;
            out.printf("천재명준호가 보냄! %d %s %d = %d\n", a, op, b, result);
            break;
          case "*":
            result = a * b;
            out.printf("천재명준호가 보냄! %d %s %d = %d\n", a, op, b, result);
            break;
          default:
            out.println("지원하지 않는 연산자 입니다.");
        }

      }
      // 클라이언트와의 연결을 끊음
      socket.close();
      System.out.println("클라이언트 연결 종료!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
