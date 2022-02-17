package com.eomcs.app2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.app2.table.ScoreTable;
import com.eomcs.app2.vo.Score;

public class ServerApp {

  public static void main(String[] args) {
    new ServerApp().service();
  }

  public void service() {
    try (ServerSocket serverSocket = new ServerSocket(3336);) {
      System.out.println("서버 실행 중...");

      while (true) {
        // 요청받은것들을 받아주는곳
        // 받은 요청을 토대로 쓰레드 생성하는곳
        // 클라이언트가 연결되면 다음 대기열을 기다린다
        new RequestHandler(serverSocket.accept()).start(); 
      } // while (true)
    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
    }
    System.out.println("종료!");
  }
  private static class RequestHandler extends Thread {

    Socket socket;
    public RequestHandler(Socket socket) {
      this.socket = socket;
    }
    @Override
    public void run() {
      try (Socket socket2 = socket; // 예외 처리를 따로 하기 싫어서 socket 이부분에 작성하는것이다.
          // socket2를 close하면 socket 객체가 담겨잇어서 자동으로 close된다
          ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
          ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());) {

        System.out.println("클라이언트가 접속했습니다.");

        while (true) {
          String command = in.readUTF();
          if (command.equals("quit")) {
            break;
          }
          try {
            switch (command) {
              case "insert":
                Score score = (Score) in.readObject();
                int count = ScoreTable.insert(score);
                out.writeUTF("success");
                out.writeInt(count);
                break;
              case "selectList":
                Score[] scores = ScoreTable.selectList();
                out.writeUTF("success");
                out.writeObject(scores);
                break;
              case "selectOne":
                int no = in.readInt();
                score = ScoreTable.selectOne(no);
                out.writeUTF("success");
                out.writeObject(score);
                break;
              case "update":
                no = in.readInt();
                score = (Score) in.readObject();
                count = ScoreTable.update(no, score);
                out.writeUTF("success");
                out.writeInt(count);
                break;
              case "delete":
                no = in.readInt();
                count = ScoreTable.delete(no);
                out.writeUTF("success");
                out.writeInt(count);
                break;
              default:
                out.writeUTF("fail");
                out.writeUTF("해당 명령을 지원하지 않습니다.");
            }
            out.flush();
          } catch (Exception e) {
            out.writeUTF("fail");
            out.writeUTF("실행 오류: " + e.getMessage());
            out.flush();
          }
        } // while (true)
        System.out.println("클라이언트와의 연결을 끊었습니다.");

      } catch (Exception e) {
        System.out.println("클라이언트와 통신 중 오류 발생!");
      }
    }
  }
}









