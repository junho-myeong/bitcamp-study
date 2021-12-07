// 변수 : 변수활용
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam4") //클래스 이름이 같을때 충돌 방지 하는 방법
@RequestMapping("/lang/variable/exam4")
public class Exam4 {

  // 스프링 부트는 클라이언트가 보낸 값을 파라미터 타입에 맞춰 자동 형변환을 수행한다.
  // => 웹브라우저가 보내는 값은 무조건 "문자열"이다.!!!!!

  //1) "100" = > byte
  //http://localhost:8080/lang/variable/exam3/test2?value=100
  @GetMapping("/test1")
  public String test1(int v1,int v2,String op) {
    int result = 0;
    switch(op) {
      case "+": result = v1+v2; break;
      case "-": result = v1-v2; break;
      case "*": result = v1*v2; break;
      case "/": result = v1/v2; break;
      default: return "해당연산을 수행할수 없습니다.";
    }
    return "===>" + result;
  }
}







