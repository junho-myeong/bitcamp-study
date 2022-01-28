package com.eomcs.app1;

import java.io.PrintStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
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

      // HTTP 요청 데이터 읽기
      String requestLine = in.nextLine();
      System.out.println(requestLine);

      // 나머지 데이터는 버린다.
      while (true) {
        String str = in.nextLine();
        if (str.length() == 0) {
          break;
        }
      }

      // 예) requestLine = Get /+/100/200 HTTP/1.1 
      String requestUri = requestLine.split(" ")[1]; // "/+/100/200"
      String[] values = requestUri.split("/"); // {"", "+", "100", "200"}

      if (values.length == 4) {

        String op = URLDecoder.decode(values[1], "UTF-8"); // "%2b" -> "+"
        int a = Integer.parseInt(values[2]); // "100"
        int b = Integer.parseInt(values[3]); // "200"
        System.out.printf("%s, %d, %d\n", op, a, b);
        String response = null;
        switch (op) {
          case "+": 
            response = String.format("천재명준호가 보냄!%d + %d  = %d", a,  b, (a+b));
            break;
          case "-": 
            response = String.format("천재명준호가 보냄!%d - %d  = %d", a,  b, (a-b));
            break;
          case "*":
            response = String.format("천재명준호가 보냄!%d  * %d  = %d", a,  b, (a*b));
            break;
          case "/":
            response = String.format("천재명준호가 보냄!%d / %d  = %d", a,  b, (a/b));
            break;
          default:
            out.println("지원하지 않는 연산자 입니다.");
        }
        writeResponse(out, response);
      } else {
        writeResponse(out, "요청 형식이 올바르지 않습니다");
      }

      // 클라이언트와의 연결을 끊음
      socket.close();
      System.out.println("클라이언트 연결 종료!");

    } catch (Exception e) {
      e.printStackTrace();
    }

  }


  // HTTP 응답 데이터
  private void writeResponse(PrintStream out, String messageBody) throws Exception {

    // 보낼 데이터를 URL 인코딩한다. 단 문자는 UTF-8 규칙(character set)에 따라 변환한다.
    String encoder = URLEncoder.encode(messageBody, "UTF-8");
    out.println("HTTP/1.1 200 OK");
    out.println("Content-Type: text/plain; charset=UTF-8");
    //    out.printf("Content-length: %d", messageBody.length());
    out.println();
    out.print(messageBody);
    out.flush();
  }
}
