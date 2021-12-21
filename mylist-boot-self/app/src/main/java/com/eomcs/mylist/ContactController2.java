package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ContactController2 {

  Contact[] contacts = new Contact[5]; // 레퍼런스 변수 5개를 넣을 배열이 준비되고, contacts 라는 변수에 그 배열의 주소가 담긴다.
  int size = 0;

  @RequestMapping("/contact2/list")
  public Object list() {
    Contact[] arr = new Contact[size]; 
    for (int i = 0; i < size; i++) { 
      arr[i] = contacts[i]; 
    }
    return arr; 
  }

  @RequestMapping("/contact2/add")
  public Object add(Contact contact) {
    if (size == contacts.length) {
      contacts = grow();
    }
    contacts[size++] = contact;
    return size;
  }

  @RequestMapping("/contact2/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "이메일이 존재하지 않습니다!";
    }
    return contacts[index];
  }

  @RequestMapping("/contact2/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return "이메일이 존재하지 않습니다!";
    }
    contacts[index] = contact;
    return 1;
  }

  @RequestMapping("/contact2/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "이메일이 존재하지 않습니다!";
    }
    remove(index);
    return 1;
  }

  /*
  // 기능: 
  // - 입력 받은 파라미터 값을 가지고 CSV 형식으로 문자열을 만들어 준다.
  //
   */

  // 기능:
  // - 이메일로 연락처 정보를 찾는다.
  // - 찾은 이메일의 배열 인덱스를 리턴한다.
  int indexOf(String email) {
    for (int i = 0; i <size; i++) {
      if(contacts[i].email.equals(email)) {
        return i;
      }
    }
    return -1;
  }


  // 기능 :
  // - 배열에서 지정한 항목을 삭제한다.
  Contact remove(int index) {
    Contact old = contacts[index];
    for (int i =index+1; i <size; i ++) {
      contacts[i - 1] = contacts[i];
    }
    size--;
    return old;
  }

  // 기능 :
  // - 배열의 크기를 늘린다.
  // - 기존배열의 값을 복사해온다.
  Contact[] grow() {
    Contact[] arr = new Contact[newLength()];
    copy(contacts, arr);
    return arr;
  }


  // 기능:
  // - 주어진 배열에 대해 배열의 크기를 50% 향상 시킨다.
  int newLength() {
    return contacts.length + (contacts.length >> 1);
  }


  //기능 :
  // - 기존의 배열을 새 배열에 복사한다.
  void copy (Contact[] source, Contact[] target) {
    for (int i =0; i <contacts.length; i++) {
      target[i] = source[i];
    }
  }
}





