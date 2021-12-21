package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.
public class ContactController2 {

  Contact[] contacts = new Contact[5];
  int size = 0;

  @RequestMapping("/contact2/list")
  public Object list() {
    Contact[] arr = new Contact[size]; // 배열에 저장된 값만 복사할 새 배열을 만든다.
    for (int i = 0; i < size; i++) { 
      arr[i] = contacts[i]; // 전체 배열에서 값이 들어 있는 항목만 복사한다.
    }
    return arr; // 복사한 항목들을 담고 있는 새 배열을 리턴한다.
  }

  @RequestMapping("/contact2/add")
  public Object add(Contact contact) { // 여기 파라미터에 contact에는 주소가 담긴다.
    // println은 굳이 toString 하지 않아도 자동으로 toString메서드를 호출한다.
    System.out.println(contact.toString());
    System.out.println(contact);

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
      return "";
    }
    return contacts[index];
  }

  @RequestMapping("/contact2/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return 0;
    }
    contacts[index] = contact;
    return 1;
  }

  @RequestMapping("/contact2/delete")
  public Object delete(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return 0;
    }
    remove(index);
    return 1;
  }

  //
  //
  int indexOf(String email) {
    for (int i = 0; i < size; i++) {
      Contact contact = contacts[i];
      if (contact.email.equals(email)) { 
        return i;
      }
    }
    return -1;
  }
  //
  Contact remove(int index) {
    Contact old = contacts[index];
    for (int i = index + 1; i <size; i++) {
      contacts[i-1] = contacts[i];
    }
    size--;
    return old;
  }
  Contact[] grow() {
    // 기존 배열 보다 50% 큰 배열을 새로 만든다.
    Contact[] arr = new Contact[newLength()];

    // 기존 배열의 값을 새 배열로 복사한다.
    copy(contacts, arr);
    return arr;
  }
  int newLength() {
    return contacts.length + (contacts.length >> 1);
  }

  void copy(Contact[] source, Contact[] target) {
    // 개발자가 잘못 사용할 것을 대비해서 다음 코드를 추가한다.
    // 즉 target 배열이 source 배열 보다 작을 경우 target 배열 크기만큼만 복사한다.
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }



}




