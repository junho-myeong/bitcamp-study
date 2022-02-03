// 파일 보내기
package com.junho.net.ex01;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver4 {

  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행중...");

    ServerSocket serverSocket = new ServerSocket(8888);
    Socket socket = serverSocket.accept();
    System.out.println("클라이너트가 연결됨.");

    PrintStream out = new PrintStream(socket.getOutputStream());
    DataInputStream in = new DataInputStream(socket.getInputStream());

    System.out.println("클라이언트로부터 데이터 수신중...");

    // 1) 파일 크기 읽기
    long filesize = in.readLong();

    // 2) 파일 이름 읽기
    String fileName = in.readUTF();

    // 3) 파일 데이터 읽어서 파일로 내보내기
    File file = new File("temp/ok_" + fileName);
    FileOutputStream fileOut = new FileOutputStream(file);

    for (long i = 0; i < filesize; i++) {
      fileOut.write(in.read());
    }
    System.out.println("클라이언트로 부터 데이터 수신완료");

    // 클라이언트에게 응답하기
    out.println("ok");
    in.close();
    out.close();
    socket.close();
    serverSocket.close();
  }

}
