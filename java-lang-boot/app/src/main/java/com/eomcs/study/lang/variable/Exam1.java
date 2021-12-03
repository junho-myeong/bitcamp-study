// 변수 : 값을 저장할 메모리를 준비시키는 명령어
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam1") //클래스 이름이 같을때 충돌 방지 하는 방법
@RequestMapping("/lang/variable/exam1")
public class Exam1 {
  // 변수 선언
  // - 값을 저장할 메모리를 준비시키는 명령문
  @GetMapping("/test1")
  // 메소드에서 변수를 준비 시키는 방법은 매개 변수로 받는 방법 으로 준비한다.
  // 단 웹브라우저가 넘겨 주는 값을 받는 방법은 매개 변수와 우리가 선언 하는 변수랑 같아야한다.
  public String test1(String name , String tel, String gender) {
    return "클라이언트에서 받은 값= " + name + "," + tel + "," + gender;
  }


  //정수 값을 저장하는 변수 선언과 값의 범위 확인  
  //http://localhost:8080/lang/variable/exam1/test2?b=100&s=200&i=50000&l=9220000000000000000
  @GetMapping("/test2")
  public String test2(byte b, short s, int i, long l) {
    return "클라이언트에서 받은 값= " + b + "," + s +"," +i +"," + l;
  }

  //부동 소수점 변수 선언과 값의 범위
  // - 부동소수점 값을 저장하는 메모리를 준비시키는 명령문.
  // - 메모리 크기에 따른 값의 유효 범위
  // - 부동소수점은 값의 범위가 넘어가도 에러가 뜨는게 아니고 짤릴뿐이다. 그래서 더 위험하다.
  // http://localhost:8080/lang/variable/exam1/test3?f=987654.321&d=9876543.2123456789
  @GetMapping("/test3")
  public String test3(float f, double d) {
    return "클라이언트에서 받은 값= " + f + " , " + d;
  }

  // 문자 변수 선언
  // -문자에 부여된 번호를 저장할 메모리를 준비시키는 명령문
  //http://localhost:8080/lang/variable/exam1/test4?c=%EA%B0%80(뒤에 부분에 퍼센트 인코딩 즉 URL인코딩을 활용해서 서버에 보내주는것이다.)
  // http://localhost:8080/lang/variable/exam1/test4?c=%EA%B0%80&c1=65 이건 안된다!! 왜안돼는지 확인!
  @GetMapping("/test4")
  public String test4(char c, char c1) {
    return "클라이언트에서 받은 값= " + c +"," +(char)0x41 +c1 + (int)c;
  }
  // 논리 변수 선언
  // -true/false 논리 값을 저장할 메모리를 준비시키는 명령문
  // 불리안에서 조심해야 하는것은 형변환이 안된다 라는것이다. true 1 false 0 (초기값)
  // 불린 리터럴은 true/false 이다 
  // -논리 값으로 1/0,ture/false를 사용할 수 잇는 이유는
  // 스프링부트가 중간에서 true/false 값으로 변환해주기 때문이다.
  @GetMapping("/test5")
  public String test5(boolean b) {
    return "클라이언트에서 받은 값= " + b + "," ;
  }


}







