// promt함수 생성하는거 다시 확인해보기
package com.eomcs.app2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.app2.handler.ScoreHandler;
import com.eomcs.util.Prompt;

public class ClientApp {


  public static void main(String[] args) {
    new ClientApp().service();
  }
  public void service() {
    try (Socket socket = new Socket("localhost", 3306);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
      System.out.println("서버와 연결 되었음!");
      ScoreHandler scoreHandler = new ScoreHandler(in, out);
      while (true) {
        printMenu();
        String input = Prompt.promptString("명령>");
        if (checkQuit(input)) {
          out.writeUTF("quit");
          out.flush();
          break;
        }
        try {
          switch (input) {
            case "1": scoreHandler.create(); break;
            case "2": scoreHandler.list(); break;
            case "3": scoreHandler.detail(); break;
            case "4": scoreHandler.update(); break;
            case "5": scoreHandler.delete(); break;
            default:
              System.out.println("올바른 메뉴 번호를 입력하시오");
          }
        } catch(Exception e) {
          System.out.println("실행중 오류 발생: " + e.getMessage());
        }
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println("서버와 통신중 오류 발생:" + e.getMessage());
    }

    System.out.println("종료!");
  }

  private void printMenu() {
    System.out.println("메뉴:");
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 상세");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
  }



  private boolean checkQuit(String input) {
    return input.equals("quit") || input.equals("exit");
  }

}
