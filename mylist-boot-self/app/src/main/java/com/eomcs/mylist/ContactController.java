package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ContactController {
  String[] contacts = new String[10];
  int size = 0;
  int updateIdx;

  @RequestMapping("/contact/list")
  public Object list() {
    //    String[] contacts = {
    //        "명준호1,wnsgh9166@naver.com,010-9032-2727,bitcamp",
    //        "명준호2,wnsgh9166@naver.com,010-9032-2727,bitcamp",
    //        "명준호3,wnsgh9166@naver.com,010-9032-2727,bitcamp",
    //        "명준호4,wnsgh9166@naver.com,010-9032-2727,bitcamp",
    //        "명준호5,wnsgh9166@naver.com,010-9032-2727,bitcamp"
    //    };
    String[] arr = new String[size];
    for(int i = 0; i<size; i++) {
      arr[i] = contacts[i];
    }
    return arr;
  }
  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    String contact = name + "," + email + "," + tel + "," + company;
    contacts[size++] = contact;
    return size;
  }
  @RequestMapping("/contact/get")
  public Object get(String email) {
    for(int i =0;i<size;i++) {
      if(contacts[i].split(",")[1].equals(email)) {
        updateIdx = i;
        return contacts[i];
      }
    }
    return "";
  }
  @RequestMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    String contact = name + "," + email + "," + tel + "," + company;
    contacts[updateIdx] = contact;
    return updateIdx;
  }
  @RequestMapping("/contact/delete")
  public Object delete() {
    for (int i = updateIdx+1; i<size; i++) {
      contacts[i-1] = contacts[i];
    }
    size--;
    return 1;
  }
}
