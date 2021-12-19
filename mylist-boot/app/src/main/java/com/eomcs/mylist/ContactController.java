package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.
public class ContactController {

  String[] contacts = new String[5];
  int size = 0;

  @RequestMapping("/contact/list")
  public Object list() {
    String[] arr = new String[size]; // 배열에 저장된 값만 복사할 새 배열을 만든다.
    for (int i = 0; i < size; i++) { 
      arr[i] = contacts[i]; // 전체 배열에서 값이 들어 있는 항목만 복사한다.
    }
    return arr; // 복사한 항목들을 담고 있는 새 배열을 리턴한다.
  }

  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    if (size == contacts.length) { // 배열이 꽉찼다면,
      contacts = grow(); // 메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    contacts[size++] = creatCSV(name, email, tel, company);
    return size;
  }

  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    return contacts[index];
  }

  @RequestMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    contacts[index] = creatCSV(name, email, tel, company);
    return 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    remove(index);
    return 1;
  }


  String creatCSV(String name, String email, String tel, String company) {
    return name + "," + email + "," + tel + "," + company;
  }

  int indexOf(String email) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) { 
        return i;
      }
    }
    return -1;
  }

  String remove(int index) {
    String old = contacts[index];
    for (int i = index + 1; i <size; i++) {
      contacts[i-1] = contacts[i];
    }
    size--;
    return old;
  }
  String[] grow() {
    // 기존 배열 보다 50% 큰 배열을 새로 만든다.
    String[] arr = new String[newLength()];

    // 기존 배열의 값을 새 배열로 복사한다.
    copy(contacts, arr);
    return arr;
  }
  int newLength() {
    return contacts.length + (contacts.length >> 1);
  }
  void copy(String[] source, String[] target) {
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




