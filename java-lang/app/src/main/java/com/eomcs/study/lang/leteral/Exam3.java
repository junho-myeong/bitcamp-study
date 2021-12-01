// 리터럴 : 정수 리터럴이 표현할 수 있는 값에 범위
package com.eomcs.study.lang.leteral;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lang/literal/exam3")
public class Exam3 {

  @GetMapping("/test1")
  public String test1() {
    //return "정수: " + 2_147_483_648; // 컴파일 오류! 4바이트 메모리에 저장할 수 없다. 
    return "정수: " + 2_147_483_647; 
    // 문자열과 숫자열을 더하면?
    // 문자열 + (숫자 ---> 문자열) = 한 개의 문자열로 합친다.
  }
  @GetMapping("/test2")
  public String test2() {
    //return "정수: " + -2_147_483_649; // 컴파일 오류! 4바이트 메모리에 저장할수 없다.
    return "정수: " + -2_147_483_648;
  }
  @GetMapping("/test3")
  public String test3() { 
    return "정수: " + 2_147_483_648l; // ok! 리터럴을 저장할때 8바이트 메모리를 사용하라고 표시한다.
  }
  @GetMapping("/test4")
  public String test4() {
    return "정수: " + -2_147_483_649L; //ok! 리터럴을 저장할때 8바이트 메모리를 사용하라고 표시한다.
  }
  @GetMapping("/test5")
  public String test5() { 
    return "정수: " + -9200000000000000000l; // ok! 리터럴을 저장할때 8바이트 메모리를 사용하라고 표시한다.
  }
  @GetMapping("/test6")
  public String test6() {
    return "정수: " + 9200000000000000000L; //ok! 리터럴을 저장할때 8바이트 메모리를 사용하라고 표시한다.
  }


}



