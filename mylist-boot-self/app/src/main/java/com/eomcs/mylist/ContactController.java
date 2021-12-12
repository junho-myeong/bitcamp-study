package com.eomcs.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()

public class ContactController {
  String[] contacts = new String[5];
  int size = 0;
  int updateIndx;
  @GetMapping("/contact/list")
  public Object list() {
    String[] records = new String[size];
    for(int i = 0; i < size; i++) {
      records[i] = contacts[i];
    }
    return records;
  }

  @GetMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    contacts[size++] = name + "," + email + "," + tel + "," + company;
    return size;
  }

  @GetMapping("/contact/get")
  public Object get(String email) {
    for (int i = 0; i < size; i++) {
      if(email.equals(contacts[i].split(",")[1])) {
        updateIndx = i;
        return contacts[i];
      }
    }
    return "";
  }
  @GetMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    contacts[updateIndx] = name + "," + email + "," + tel + "," + company;
    return updateIndx;
  }
}

