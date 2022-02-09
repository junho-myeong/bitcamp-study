// stateless 방식에서 클라이언트를 구분하고 작업 결과를 유지하는 방법
package com.eomcs.net.ex04.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);

    // 서버에서 이 클라이언트를 구분할 때 사용하는 번호이다.
    // => 0 번으로 서버에 요청하면, 서버가 신규 번호를 발급해 줄 것이다.
    long clientId = 0; // 공식적으로 웹브라우저에서 부르는 방법은 세션 아이디라고 부른다.
    // 네이버에서 로그인시에 세션 아이디에 내 정보가 들어 간다
    // 그래서 한번더 브라우저를 띄우면 그 세션아이디가 그대로 잇고
    // 만약 브라우저를 다 종료하고 다시 키면 세션 아이디에 내 정보가 없기 때문에
    // 신규 고객으로 간주해서 다시 로그인하라고 한다.
    // 그럼 전에 잇던 세션 아이디는 가비지 된다.
    // 그리고 서버에서 일정시간이 지나면 가비지는 지운다

    while (true) {
      System.out.print("연산자? ");
      String op = keyScan.nextLine();

      System.out.print("값? ");
      int value = Integer.parseInt(keyScan.nextLine());

      try (Socket socket = new Socket("localhost", 8888);
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(socket.getInputStream())) {

        // => 서버에 클라이언트 아이디를 보낸다.
        out.writeLong(clientId);

        // => 서버에 연산자와 값을 보낸다.
        out.writeUTF(op);
        out.writeInt(value);
        out.flush();

        // => 서버에서 보낸 클라이언트 아이디를 읽는다.
        clientId = in.readLong();

        // => 서버에서 보낸 결과를 읽는다.
        System.out.println(in.readUTF());

      } catch (Exception e) {
        System.out.println("서버와 통신 중 오류 발생!");
      }

      System.out.print("계속하시겠습니까?(Y/n)");
      if (keyScan.nextLine().equalsIgnoreCase("n")) {
        break;
      }
    }

    keyScan.close();
  }
}


