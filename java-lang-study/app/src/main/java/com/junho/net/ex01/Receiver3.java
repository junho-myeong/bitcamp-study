// 서버 + 키보드 입력 + 무한 반복
package com.junho.net.ex01;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Receiver3 {

  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행!");

    Scanner keyScan = new Scanner(System.in);

    ServerSocket serversocket = new ServerSocket(8888);
    Socket socket = serversocket.accept();

    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    while (true) {
      // 클라이언트가 보낸 문자열을 수신한다.
      System.out.println(in.nextLine());

      // 키보드 입력을 받아서 클라이언트로 송신한다.
      System.out.print("입력>");
      String input = keyScan.nextLine();
      out.println(input);
      if (input.equals("quit")) { // 또 실수함!!! String 객체에 인스턴스 내용물이 같은지 비교는 무조건 equals이다!!!!
        break;
      }
    }

    in.close();
    out.close();
    socket.close();
    serversocket.close();
    keyScan.close();
  }

}
