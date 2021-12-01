// 리터럴 : 부동 소수점 리터럴과 값의 범위
package com.eomcs.study.lang.leteral;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lang/literal/exam4")
public class Exam4 {

  static float x = 12.375f;
  //test1 은 명령어 블록 즉 메소드라고 부른다.
  @GetMapping("/test1")
  public String test1() {
    float value = 987.6543f; //4바이트 메모리 사용 하는 리터럴, 유효자리수를 넘어가는 값은 짤린다.
    return "부동소수점: " + value;
  }

  @GetMapping("/test2")
  public String test2() {
    double value = 987654321.123456; // 8바이트 메모리 사용 하는 리터럴
    return "부동소수점: " + value;
  }

  @GetMapping("/test3")
  public String test3() {
    float value = 987.654321f; //4바이트 메모리 크기를 넘어서는 값(유효 자리수 7자리)은 짤린다.
    return "부동소수점: " + value;
  }

  @GetMapping("/test4")
  public String test4() {
    double value = 987654321.12345678987654; // 8바이트 메모리 크기 넘어서는 값(유효자리수 15자리)는 짤린다
    return "부동소수점: " + value;
  }

}



