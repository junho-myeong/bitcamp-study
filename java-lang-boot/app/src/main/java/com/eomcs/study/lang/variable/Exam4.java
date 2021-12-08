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
    //이렇게 서버에서 웹브라우저가 출력할 화면을
    // html로 만들어 클라이언트로 보내는 것을
    // "서버측 렌더링(server-side rendering) 이라고 부른다
    String html = "<!DOCTYPE html>";
    html = html + "<html>";
    html = html + "<head>";
    html = html + "<meta charset=\"UTF-8\">";
    html = html + "<title>변수 활용</title>";
    html = html + "</head>";
    html = html + "<body>";
    html = html + "<h1>계산결과</h1>";
    html = html + "<p>" +v1 + " " + op + " " + v2 + " = " +result + "</p>";
    html = html + "</body>";
    html = html + "</html>";

    return html;
  }


  // 2) 클라이언트 렌더링은 WebBrowser 에서 서버에서 받은 결과값만 가지고 html을 생성/변경/삭제 해서 화면 출력한다.
  @GetMapping("/test2")
  public Object test2(int v1,int v2,String op) {
    System.out.println(">" + v1 + "<");
    System.out.println(">" +v2 + "<");
    System.out.println(">" +op + "<");
    int result = 0;
    switch(op) {
      case "+": result = v1+v2; break;
      case "-": result = v1-v2; break;
      case "*": result = v1*v2; break;
      case "/": result = v1/v2; break;
      default: return "해당연산을 수행할수 없습니다.";
    }

    return result; // integer는 정수를 다루는 기능들이 잇고 .을 찍으면 그거와 관련된 기능들이 나온다.
    //java.lang 패키지에 잇는 클래스 들은 java.lang을생략해서 사용해도 된다.
    // 리턴 받는 데이터 타입을 Object라고 설정하면 굳이 문자열 이랑 정수로 타입을 맞출 필요없다.
  }

  @GetMapping("/test3")
  public Object test3() {
    String[] names;
    names = new String[] {"홍길동","유관순","안중근","윤봉길"};

    return names; // 스프링부트는 이 메서드가 리턴한 배열을 JSON 형식의 문자열로 가공해서 응답한다.
  }


}







