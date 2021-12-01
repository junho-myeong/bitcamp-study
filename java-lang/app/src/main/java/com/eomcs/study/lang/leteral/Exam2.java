// 리터럴 : 숫자를 표현하는 다양한 방법 - 진수법
package com.eomcs.study.lang.leteral;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lang/literal/exam2")
public class Exam2 {

  @GetMapping("/test1")
  public int test1() {
    return 100; // 10진수 (숫자를 표현할때기본으로 많이 사용)
  }
  @GetMapping("/test2")
  public int test2() {
    return 0144; // 8진수를표현하는 식 맨앞에 0을 붙인다.
  }
  @GetMapping("/test3")
  public int test3() {
    return 0b0110_0100; // 2진수를표현하는 식 맨앞에 0b를 붙인다. _붙여도 된다 , 4비트씩 쉽게 구분가능
  }
  @GetMapping("/test4")
  public int test4() {
    return 0x64; // 16진수(문자의 코드 값을 표현할때 많이사용)를표현하는 식 맨앞에 0x를 붙인다. , 16진수는 2진수를 짧게 표기할때 유용하다. ex 0110  0100 앞에 6 뒤에 4 그래서 0x64
  }
}



