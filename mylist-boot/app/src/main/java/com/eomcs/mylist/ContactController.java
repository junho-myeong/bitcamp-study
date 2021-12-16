package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이클래스가 클라이언트 요청을 처리한다는 것을 표시한다. 
// 이 표시(에노테이션)이 붙어 있어야만 스프링 부트가 인식한다.

public class ContactController {

  String[] contacts = new String[5];
  int size = 0;
  int updateIdx;

  @RequestMapping("/contact/list") // 이 URL(unified resource locator)이 연결되면 이 메소드를 호출할것이다.
  public Object list() {
    //    String[] contacts = {
    //        "aaa11,aaa@test.com,1111,비트캠프",
    //        "aaa22,aaa@test.com,1111,비트캠프",
    //        "aaa33,aaa@test.com,1111,비트캠프",
    //        "aaa44,aaa@test.com,1111,비트캠프",
    //        "aaa55,aaa@test.com,1111,비트캠프"
    //    };
    String[] arr = new String[size]; // 배열에 저장된 값만 복사할 새 배열을 만든다.
    for (int i = 0; i<size;i++) {
      arr[i] = contacts[i]; // 전체 배열에서 값이 들어 있는 항목만 복사한다.
    }
    return arr; // 복사한 배열 항목들을 담고 있는 새 배열을 리턴한다.
  }

  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    contacts[size++] = createCSV(name, email, tel, company);
    return size; //현재 몇개를 입력했는지 알기위해 
  }

  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contacts[index];
  }
  @RequestMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    contacts[updateIdx] = createCSV(name, email, tel, company);
    return updateIdx;
  }
  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    for (int i = 0; i<size;i++) {
      if(contacts[i].split(",")[1].equals(email)) {

        // 현재 위치의 다음 항목에서 배열 끝까지 반복하면 앞으로 갚을 당겨온다.
        for (int j = i +1;j<size ; j++) {
          contacts[j-1] = contacts[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  }

  //  기능:
  //  -입력 받은 파라미터 값을 가지고 CSV 형식으로 문자열을 만들어 준다.
  String createCSV(String name, String email, String tel, String company) {
    return name + "," + email + "," + tel + "," + company;
  }

  // 기능:
  //  - 이메일로 연락처 정보를 찾는다.
  //  - 찾은 연락처의 배열 인덱스를 리턴한다.
  int indexOf(String email) {
    for (int i = 0; i<size;i++) {
      if(contacts[i].split(",")[1].equals(email)) {
        updateIdx = i;
        return i;
      }
    }
    return -1;
  }

}




