package com.eomcs.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController() // 클라이언트 요청을 처리 하는 역활(클라이언트가 뭘 해달라고 하면 해주는것)
public class ContactController {
  // 인스턴스 변수
  // => 모든 인스턴스 메소드가 공유한다.
  String[] contacts = new String[5];
  int size = 0;

  @GetMapping("/contact/list")
  public Object list() {
    String[] records =new String[size];
    for(int i = 0; i <size; i++) {
      records[i] = contacts[i];
    }
    return records;
  }

  @GetMapping("/contact/add")
  public Object add(String name,String email, String tel, String company) {
    //String contact = // json으로 보내는게 아니다 ""가 맨 앞뒤에 없다
    contacts[size++] = name + "," + email + "," + tel + "," + company;
    return size;
  }
  @GetMapping("/contact/get")
  public Object get(String email) {
    for (int i =0; i<size;i++) {
      if (email.equals(contacts[i].split(",")[1])) {
        return contacts[i];
      }
    }
    return "";
  }


}
