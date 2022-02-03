package com.eomcs.app1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {
  @RequestMapping("/calc")
  // 쿼리 스트링에 변수와 값을 받는 방법
  // URL Decoding 할필요도 없다.
  public String calc(String op, double a, double b) {
    String response = null;
    switch (op) {
      case "+": 
        response = String.format("천재명준호가 보냄!%.1f + %.1f  = %.2f", a,  b, (a+b));
        break;
      case "-": 
        response = String.format("천재명준호가 보냄!%.1f - %.1f  = %.2f", a,  b, (a-b));
        break;
      case "*":
        response = String.format("천재명준호가 보냄!%.1f  * %.1f  = %.2f", a,  b, (a*b));
        break;
      case "/":
        response = String.format("천재명준호가 보냄!%.1f / %.1f  = %.2f", a,  b, (a/b));
        break;
      default:
        response = "명준호: 지원하지 않는 연산자 입니다.";
    }
    return response;
  }
}
