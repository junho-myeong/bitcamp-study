package com.eomcs.net.ex12.awt;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// WindowAdapter와 WindowListener 차이를 알아 본다.
// 윈도우 어뎁터는 관심잇는 메서드만 처리해도 된다는 장점이 잇다.
// 이 클래스는 ChatClinet의 main()에서만 사용할 수 있습니다.

public class MyWindowListener extends WindowAdapter{

  @Override
  public void windowClosing(WindowEvent e) {
    // 윈도우의 x 버튼을 눌렸을때
    System.exit(0); // 정상적으로 종료할 때 파라미터 값을0을 준다.
  }

}
