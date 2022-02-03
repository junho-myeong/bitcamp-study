//  클라이언트 + 키보드 입력 + 무한 반복
package com.junho.net.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender3 {

  public static void main(String[] args) throws Exception {
    System.out.println("클라이언트 실행!");

    Scanner keyScan = new Scanner(System.in);
    Socket socket = new Socket("localhost", 8888);

    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    while (true) {
      // 키보드 입력을 받아서 서버에게 전송한다.
      System.out.print("입력>");
      String input = keyScan.nextLine();
      out.println(input);

      // 서버가 보낸 데이터를 수신한다.
      String str = in.nextLine();
      System.out.println(str);
      if (str.equals("quit")) { // 또 실수함!!! String 객체에 인스턴스 내용물이 같은지 비교는 무조건 equals이다!!!!
        break;
      }

    }

    in.close();
    out.close();
    socket.close();
    keyScan.close();
  }

}
