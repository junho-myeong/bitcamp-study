// 리터럴: 문자열 리터럴 과 esacpe cahracter EX700
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 여기서 mapping 주소는 꼭 패키지랑 같아야 하는게 아니고 내맘대로 해도 된다.
@RequestMapping("/lang/literal/exam6")
public class Exam6 {

  @GetMapping("/test1")
  public String test1() {
    return "012ABC가각간똘똠똡똥";
  }
  @GetMapping("/test2")
  public String test2() {
    // 제어 코드
    // \n : new line (line feed)
    // \r : Carriage Return
    return "012\nABC\n가각간\n똘똠똡똥";
  }
  @GetMapping("/test3")
  public String test3() {
    // 제어 코드
    // \n : new line (line feed)
    // \r : Carriage Return
    return "012\rABC\r가각간\r똘똠똡똥"; //웹 브라우저에서는 소용 없다. 단, 프롬프트에서 확인할수잇다.
  }
  @GetMapping("/test4")
  public String test4() {
    // 제어 코드
    // \n : new line (line feed)
    // \r : Carriage Return
    return "012\tABC\t가각간\t똘똠똡똥";
  }
  @GetMapping("/test5")
  public String test5() {
    // 제어 코드
    // \n : new line (line feed)
    // \r : Carriage Return
    return "012\bABC\b가각간\b똘똠똡똥"; // \b 웹 브라우저 에서는 소용 없다.
  }
  @GetMapping("/test6")
  public String test6() {
    // 제어 코드
    // \n : new line (line feed)
    // \r : Carriage Return
    return "012\\ABC\\가각간\\똘똠똡똥";
  }
  @GetMapping("/test7")
  public String test7() {
    // 제어 코드
    // \n : new line (line feed)
    // \r : Carriage Return
    return "012\"ABC\"가각간\"똘똠똡똥";
  }
}







