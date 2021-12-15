package com.eomcs.web.javascript;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex00controller {
  @RequestMapping("/javascript/ex00/exam06") // ex00/exam06 에 관련된 메소드 이다라는걸 나타내는것이다. 
  public String exam06() {
    return "<ul><li>홍길동</li><li>임꺽정</li><li>유관순</li><li>안중근</li></ul>"; // UI 조각을 만들어 던진다.
  }
  @RequestMapping("/javascript/ex00/exam07")
  public Object exam07() {
    String[] names = {"홍길동","임꺽정","유관순"};
    return names; // UI 를 던지는게 아니고 데이터를 던지고 클라이언트에서 html 태그들 실행한다.
  }
}
