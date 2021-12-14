package com.eomcs.web.javascript;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex01controller {
  @RequestMapping("/javascript/ex01/exam05_1") // ex00/exam06 에 관련된 메소드 이다라는걸 나타내는것이다. 
  public Object exam05_1() throws Exception {
    Thread.sleep(10000); // 10초 동안 기다렸다가 작업을 재개 한다.
    return "console.log('dff')"; //  자바 스크립트 코드 조각을 리턴한다. , 반드시 자바스크립트 코드를 리턴해야한다.
  }
  @RequestMapping("/javascript/ex01/exam05_2")
  public Object exam05_2() {
    return "window.alert('nono')"; // 자바 스크립트 코드 조각을 리턴한다.
  }
  @RequestMapping("/javascript/ex01/exam05_x")
  public Object exam05_x() throws Exception{
    Thread.sleep(10000);
    return "50,000"; // 데이터를 리턴한다.
  }
}
