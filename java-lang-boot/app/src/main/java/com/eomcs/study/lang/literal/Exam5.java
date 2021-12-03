// 리터럴: 문자 리터럴
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 여기서 mapping 주소는 꼭 패키지랑 같아야 하는게 아니고 내맘대로 해도 된다.
@RequestMapping("/lang/literal/exam5")
public class Exam5 {

  @GetMapping("/test1")
  public String test1() {
    return "문자1: " + 'A' + '가';
  }

  @GetMapping("/test2")
  public String test2() {
    return "문자2: " + '\u0041' + '\uac00'; // 문자에 대한 유니코드 값을 지정해도 된다.
  }

  @GetMapping("/test3")
  public String test3() {
    return "문자3: " + 0x41 + "," + 0xac00 ; // 문자 코드를 정수 값으로 지정한다.
    // 우리는 65라는 정수값을 ox41이라고 표기했을뿐이다. 
    // 그래서 10진수 형태로 문자열과 합쳐 져서 하나의 문자열이 만들어 진것이다.
    // 대신 문자를 가리키는 코드임을 표시해야 한다.(기계는 문자를 가르키는 번호인줄을 모른다)
  }
  // 위, 아래 차이 꼭비교하기
  @GetMapping("/test4")
  public String test4() {
    return "문자3: " + "0x41" + "," + "0xac00"; // 문자 코드를 정수 값으로 지정한다. 우리는 65라는 정수값을 ox41이라고 표기했을뿐이다. 그래서 10진수 형태로 문자열과 합쳐 져서 하나의 문자열이 만들어 진것이다.
    // 대신 문자를 가리키는 코드임을 표시해야 한다.
  }

  @GetMapping("/test5")
  public String test5() {
    return "문자2: " + (char)0x41 + "," + (char)0xac00; // 문자의 코드 값은 그냥 정수 값이다. 
    // 대신 문자를 가리키는 코드임을 표시해야 한다.
  }

  @GetMapping("/test6")
  public String test6() {
    return "문자2: " + (double)0x41 + "," + (char)44032; // 문자의 코드 값은 그냥 정수 값이다. 
    // 대신 문자를 가리키는 코드임을 표시해야 한다.
  }

  @GetMapping("/test7")
  public String test7() {
    return "특수문자: " + '\u42ba' + '\u00a9' + '\u03c0' + '\u03a3'; 
    // 키보드에서 입력 불가능한 특수 문자를 입력할때 주로 유니코드를 사용한다.
  }
}







