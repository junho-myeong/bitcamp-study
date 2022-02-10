package com.eomcs.net.ex12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class ChatServer {

  int port;

  ArrayList clientOutputStreams = new ArrayList();

  public ChatServer(int port) {
    this.port = port;
  }

  public void service() {
    try (ServerSocket serversocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중....");

      while (true) {
        new RequestHandler(serversocket.accept()).start();

      }
    } catch (Exception e) {
      System.out.println("서버 실행중 오류 발생" + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public void sendMessage(String message) {
    ArrayList deleteStreams = new ArrayList();
    for (int i = 0; i <clientOutputStreams.size(); i++) {
      DataOutputStream out = (DataOutputStream) clientOutputStreams.get(i);
      try {
        out.writeUTF(message);
      } catch (Exception e) {
        System.out.println("전송 오류:" + message);
        //        clientOutputStreams.remove(i);
        deleteStreams.add(out); // remove로 삭제시 땡겨지기 때문에 지금 삭제가 아니고 모아둔다
      }
    }
    for (Object deleteStream : deleteStreams) { // 삭제명단에 등록된 출력 스트림을 제거한다.
      clientOutputStreams.remove(deleteStream);
    }
  }
  class RequestHandler extends Thread {
    Socket socket;
    public RequestHandler(Socket socket) {
      this.socket = socket;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
      try (Socket socket2 = socket;
          DataInputStream in = new DataInputStream(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream())){
        clientOutputStreams.add(out);
        String nickname = in.readUTF();
        out.writeUTF(nickname + "님 환영합니다!\n");
        while (true) {
          String message = in.readUTF();
          if (message.equals("\\quit")) {
            out.writeUTF("<![QUIT[]>"); // 연결을 끊겠다는 특별한 메세지를 클라이언트에게 보낸다.
            out.flush();
            clientOutputStreams.remove(out); // 메세지 출력 목록에서 연결을 끊은 클라이언트는 제거한다.
            break;
          }
          sendMessage(String.format("[%s] %s", nickname,  message));
        }

      } catch (Exception e) {
        System.out.println("클라이언트와 통신 오류!" + e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    new ChatServer(8888).service();
  }
}
