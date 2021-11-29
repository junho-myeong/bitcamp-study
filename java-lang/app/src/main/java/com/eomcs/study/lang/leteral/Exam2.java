package com.eomcs.study.lang.leteral;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lang/literal/exam1")
public class Exam2 {

  @GetMapping("/test1")
  public String test1() {
    // 문자열을 나타내는
    return "홍길동";
  }
  @GetMapping("/test2")
  public char test2() {
    return '홍';
  }
  @GetMapping("/test3")
  public int test3() {
    return 100;
  }
  @GetMapping("/test4")
  public float test4() {
    return 3.14f;
  }
  @GetMapping("/test5")
  public boolean test5() {
    return true;
  }
  @GetMapping("/test6")
  public Object test6() {
    return null;
  }
}



