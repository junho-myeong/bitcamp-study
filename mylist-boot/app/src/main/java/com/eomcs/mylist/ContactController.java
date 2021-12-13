package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이클래스가 클라이언트 요청을 처리한다는 것을 표시한다. 
// 이 표시(에노테이션)이 붙어 있어야만 스프링 부트가 인식한다.

public class ContactController {

  @RequestMapping("/contact/list") // 이 URL(unified resource locator)이 연결되면 이 메소드를 호출할것이다.
  public Object list() {
    String[] contacts = {
        "aaa11,aaa@test.com,1111,비트캠프",
        "aaa22,aaa@test.com,1111,비트캠프",
        "aaa33,aaa@test.com,1111,비트캠프",
        "aaa44,aaa@test.com,1111,비트캠프",
        "aaa55,aaa@test.com,1111,비트캠프"
    };
    return contacts;
  }

  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    String contact = name + "," + email + "," + tel + "," + company;
    return contact;
  }
}
