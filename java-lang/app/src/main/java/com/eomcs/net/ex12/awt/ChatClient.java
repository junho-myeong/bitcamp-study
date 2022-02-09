package com.eomcs.net.ex12.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame {

  public ChatClient() {
    super("계산기");
    // 익명생성자를 호출 하는 방법
    // 그래서 슈퍼 클래스의 생성자를 호출 해야한다.
    // 익명 클래스를 호출 하는것이다.
    // 이렇게 익명클래스로 호출하면 바로 근처에 잇어서 소스코드를 사용하기 쉬워진다.
    // 즉 중첩클래스를 사용하는 이유는 우리가 한눈에 보기 편하기 위해서이다.
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        // 윈도우의 x 버튼을 눌렸을때
        System.exit(0); // 정상적으로 종료할 때 파라미터 값을0을 준다.
      }
    }); // 컴퓨터에 모니터를 연결하는것이라고 생각하면 된다.
    this.setSize(400, 300);
    this.setVisible(true);
  }
  public static void main(String[] args) {

    // 메서드 안에 클래스 선언할때는 public을 쓰면 안된다.
    // 이 윈도우리스너란 클래스는 main안에서만 사용할것이라고 말해주는것이다.
    // 네스티드 클래스이다.
    class MyWindowListener extends WindowAdapter{
      @Override
      public void windowClosing(WindowEvent e) {
        // 윈도우의 x 버튼을 눌렸을때
        System.exit(0); // 정상적으로 종료할 때 파라미터 값을0을 준다.
      }
    }

    new ChatClient();

  }
}
