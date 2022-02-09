// awt에서 제공하는것을 토대로 window제작하기
package com.eomcs.net.ex12.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ChatClient extends JFrame {

  private static final long serialVersionUID = 1L;
  JTextField addressTf = new JTextField(30);
  JTextField portTf = new JTextField(4);
  JTextField messageTf = new JTextField(35);
  JTextArea messageListTa = new JTextArea();
  Socket socket;
  public ChatClient() {
    super("계산기");
    // 익명생성자를 호출 하는 방법
    // 그래서 슈퍼 클래스의 생성자를 호출 해야한다.
    // 익명으로 클래스를 호출 하는것이다.
    // 이렇게 익명클래스로 호출하면 바로 근처에 잇어서 소스코드를 사용하기 쉬워진다.
    // 즉 중첩클래스를 사용하는 이유는 우리가 한눈에 보기 편하기 위해서이다.
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try { socket.close();} catch (Exception ex) {}
        // 윈도우의 x 버튼을 눌렸을때
        System.exit(0); // 정상적으로 종료할 때 파라미터 값을0을 준다.
      }
    }); // 컴퓨터에 모니터를 연결하는것이라고 생각하면 된다.
    this.setSize(500, 400);

    Container contentPane = this.getContentPane();

    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    topPanel.add(addressTf);
    topPanel.add(portTf);

    JButton connectBtn = new JButton("연결");
    class MyActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

      }
    }
    // 파라미터가 인터페이스이고 추상 메서드가 한개인 경우 람다 메서드 사용 가능한다.
    //    connectBtn.addActionListener( e -> System.out.println("연결 버튼 눌렀구만!"));

    // 4) 메서드 레퍼런스
    // 원래 파라미터에는 인스턴스구현체가 와야하는데 그걸 구현하기 귀찮아서 
    // 메서드 시그니쳐가 같은걸 만들어서 그걸 사용한다는 뜻이다.
    connectBtn.addActionListener(this::connectChatServer);
    topPanel.add(connectBtn);

    contentPane.add(topPanel, BorderLayout.NORTH);


    contentPane.add(messageListTa, BorderLayout.CENTER);

    JPanel bottomPanel = new JPanel();

    bottomPanel.add(messageTf);

    JButton sendBtn = new JButton("보내기");
    sendBtn.addActionListener(this::sendMessage);
    bottomPanel.add(sendBtn);
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    contentPane.add(bottomPanel, BorderLayout.SOUTH);
    this.setVisible(true);
  }
  public static void main(String[] args) throws Exception {
    // 크로스 브라우징을 통해 각 os에 기본 테마 없이 사용한다는뜻이다.
    // 밑에를 기준으로 plain에 버튼을 그리는것이다.
    //    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    //    com.sun.java.swing.plaf.motif.MotifLookAndFeel
    //    com.sun.java.swing.plaf.gtk.GTKLookAndFeel
    //    com.sun.java.swing.plaf.windows.windowsLookAndFeel
    //    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    //    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    System.out.println(UIManager.getCrossPlatformLookAndFeelClassName());
    new ChatClient();

  }
  public void connectChatServer(ActionEvent e) {
    System.out.println("서버에 연결하기!!");
    System.out.println(addressTf.getText());
    System.out.println(portTf.getText());

    try {
      socket = new Socket(addressTf.getText(), Integer.parseInt(portTf.getText()));
    } catch(Exception ex) {
      System.out.println("서버에 연결중 오류 발생");
    }
  }
  public void sendMessage(ActionEvent e) {
    System.out.println("메세지 보내기!!");
    System.out.println(messageTf.getText());
  }
}
