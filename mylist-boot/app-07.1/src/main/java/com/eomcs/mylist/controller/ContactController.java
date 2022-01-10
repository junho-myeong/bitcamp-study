package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.io.FileWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList;

@RestController 
public class ContactController {

  ArrayList contactList; // ArrayList에 설계도에 따라 메모리 준비하는 단계

  public ContactController() throws Exception {
    contactList = new ArrayList();
    System.out.println("ContactController() 호출됨!!!");

    FileReader in = new FileReader("contacts.csv");

    StringBuilder buf = new StringBuilder();
    int c;
    while (true) {
      c = in.read(); // 파일에서 한 문자를 읽는다!
      if (c == -1) // 만약 더이상 읽을 문자가 없다면 반복문을 종료한다.
        break;
      if (c == '\n') { // 만약 읽은 문자가 줄바꿈이라면, 지금까지 읽은 csv 데이터를 분석하여 Contact 객체에 담는다.!! // 파일에서 읽을 데이터를 담을 객체준비, 그리고 객체를 초기화 시킨다.
        contactList.add(Contact.valueOf(buf.toString())); // 스태틱 메서드를 사용
        buf.setLength(0); // 다음데이터를 읽기 위해 버퍼를 초기화 시킨다.
      }else { // 문자를 읽을때 마다 buf에 일시 보관한다,
        buf.append((char) c);
      }
      //      System.out.print((char) c);
    }
    in.close();
  }

  @RequestMapping("/contact/list")
  public Object list() {
    return contactList.toArray(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    contactList.add(contact);
    return contactList.size();
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contactList.get(index);
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.getEmail());
    if (index == -1) {
      return 0;
    }

    return contactList.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    contactList.remove(index);
    return 1;
  }

  @RequestMapping("/contact/save")
  public Object save() throws Exception {
    FileWriter out = new FileWriter("contacts.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 파일이 생성된다.

    Object[] arr = contactList.toArray();
    for (Object obj: arr) {
      Contact contact = (Contact) obj;
      out.write(contact.toCsvString() + "\n");
    }
    out.close(); // 파일이랑 systemin 같은것들은 사용하고 닫아 주는 습관 들이기
    return 0;
  }

  int indexOf(String email) {
    for (int i = 0; i < contactList.size(); i++) {
      Contact contact =  (Contact) contactList.get(i);
      if (contact.getEmail().equals(email)) { 
        return i;
      }
    }
    return -1;
  }
}




