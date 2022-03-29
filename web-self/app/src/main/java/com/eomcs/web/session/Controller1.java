package com.eomcs.web.session;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

  @RequestMapping("/session/step1")
  public Object step1(String name, HttpSession session) {
    session.setAttribute("name", name);
    return "step1()실행!";
  }


  @RequestMapping("/session/step2")
  public Object step2(int age, HttpSession session) {
    session.setAttribute("age", age);
    return "step2()실행!";
  }

  @RequestMapping("/session/step3")
  public Object step3(boolean working, HttpSession session) {
    session.setAttribute("working", working);
    return "step3()실행!";
  }

  @RequestMapping("/session/step4")
  public Object step4(HttpSession session) {
    //    String name = (String) session.getAttribute("name");
    //    int age = (int) session.getAttribute("age");
    //    boolean working = (boolean) session.getAttribute("working");
    //    System.out.printf("%s , %d, %b", name, age, working);
    //    return "step4()실행!";

    // HashMap객체로 가져오면 다음에 데이터를 가져올때 더 사용하기 편리하다
    HashMap<String, Object> map = new HashMap<>();
    map.put("name", session.getAttribute("name"));
    map.put("age", session.getAttribute("age"));
    map.put("working", session.getAttribute("working"));
    return map;
  }

}
