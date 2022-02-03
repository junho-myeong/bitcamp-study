// 클라이언트 + 키보드 입력
package com.junho.net.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender2 {

  public static void main(String[] args) throws Exception {
    System.out.println("클라이언트 실행!");

    Scanner keyScan = new Scanner(System.in);

    Socket socket = new Socket("localhost", 8888);

    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    System.out.print("보낼데이터 입력>");
    out.println(keyScan.nextLine());

    System.out.println(in.nextLine());

    in.close();
    out.close();

    socket.close();
    keyScan.close();
  }

}
