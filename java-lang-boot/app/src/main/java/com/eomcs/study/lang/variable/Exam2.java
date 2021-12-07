// 배열 : 같은 종류의 메모리를 여러 개 만드는 명령문
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam2") //클래스 이름이 같을때 충돌 방지 하는 방법, 스프링 부트가 클래스를 관리할때 사용하는 이름표 , servlet container 가 어떤 exam1 을 가르키는 지 모르기 때문에 이름을 붙여 줘야한다(패키지가 달라도 spring boot는 그것을 모른다).
@RequestMapping("/lang/variable/exam2") // 클래스에 이 메소드를 선언해달라고 하는 메소드이다(즉 경로다). / 웹브라우저가 요청하는 주소를 말한다.
public class Exam2 {

  // 여러개의 값을 받는 방법 : 배열 사용하기 전
  // => http://localhost:8080/lang/variable/exam2/test1?name1=%ED%99%8D%EA%B8%B8%EB%8F%99&name2=%EC%9E%84%EA%BA%BD%EC%A0%95&name3=%EC%9C%A0%EA%B4%80%EC%88%9C&name4=%EC%95%88%EC%A4%91%EA%B7%BC&name5=%EA%B9%80%EA%B5%AC&name6=%EC%9C%A4%EB%B4%89%EA%B8%B8
  @GetMapping("/test1")
  public String test1(String name1, String name2, String name3, String name4, String name5, String name6) {
    return "=> " + name1 + "," + name2 + "," + name3 + "," + name4 +"," + name5 + "," + name6 + ".";
  }

  // 여러개의 값을 받는 방법 : 배열 사용후
  // => 배열 메모리에 값을 넘길때는 같은 parameter 이름을 사용해야한다.!!!
  // name1,name2 이런게 아니고 하나 name에 값을 다 넣어 주면 된다.
  // http://localhost:8080/lang/variable/exam2/test2?name=%ED%99%8D%EA%B8%B8%EB%8F%99&name=%EC%9E%84%EA%BA%BD%EC%A0%95&name=%EC%9C%A0%EA%B4%80%EC%88%9C&name=%EC%95%88%EC%A4%91%EA%B7%BC&name=%EA%B9%80%EA%B5%AC&name=%EC%9C%A4%EB%B4%89%EA%B8%B8
  @GetMapping("/test2")
  public String test1(String[] name) {
    return "=> " + name[0] + "," + name[1] + "," + name[2] + "," + name[3] +"," + name[4] + "," + name[5] + ".";
  }

}







