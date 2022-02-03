// 상대편에 연결을 요청하기 - 클라이언트(client)
package com.junho.net.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender {
  public static void main(String[] args) throws Exception {
    System.out.println("클라이언트 실행!");

    // 1) 다른 컴퓨터와 네트워크로 연결한다.
    // => 서버와 연결되면 Socket 객체가 생성된다.
    // => 서버와 연결될 때 까지 리턴하지 않는다.
    //      - 기본으로 설정된 타임아웃 시간 까지 연결 되지 않으면 예외가 발생한다.
    // new socket("원격 호스트의 IP주소/도메인이름", 원격 호스트 프로그램의 포트번호)
    //  => 원격 호스트의 IP주소/도메인이름(로컬인경우, 127.0.0.1/localhost) : 현재 컴퓨터를 가리킨다.
    // 로컬호스트란? 애플리케이션을 실행하는 현재 컴퓨터
    Socket socket = new Socket("localhost", 8888); // 서버에 대기열에서 accept될 때 리턴된다.
    System.out.println("서버와 연결된 Socket 생성!");

    // 2) 소켓 객체를 통해 읽고 쓸 수 있도록 입출력 스트림을 얻는다.
    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());
    System.out.println("서버와 데이터를 송수신할 스트림 준비 완료!");

    // 3) 상대편으로 문자열을 한 줄 보낸다.
    out.println("명준호가 클라이언트에서 서버로 보낸 메세지입니다.");

    // 4) 상대편에서 보낸 문자열을 한 줄 읽는다.
    //  => 상대편이 한 줄 데이터를 보낼 때 까지 리턴 하지 않는다.
    //  => 이런 메서드를 블로킹 메서드라 부른다.
    String str = in.nextLine();
    System.out.printf("서버에서 보낸 문자열은: %s \n", str);

    // 5) 항상 입출력 도구는 사용 후 닫아야 한다.
    in.close();
    out.close();

    // 6) 네트워크 연결도 닫는다.
    socket.close();

  }
}
