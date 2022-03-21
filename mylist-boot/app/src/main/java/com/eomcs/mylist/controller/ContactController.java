package com.eomcs.mylist.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;
import com.eomcs.mylist.service.ContactService;

@RestController 
public class ContactController {

  // 여기 클래스 이름 변경을 통해 non을사용할 고객사인지 트랜잭션 이용할 고객사인지 판단
  @Autowired
  ContactService contactService; // 클래스 대신 인터페이스를 지정한다.


  @RequestMapping("/contact/list")
  public Object list() {
    return contactService.list();
  }


  @RequestMapping("/contact/add")
  public Object add(Contact contact, String[] tel) throws Exception {
    // 요청 파라미터 분석 및 가공
    ArrayList<ContactTel> telList = new ArrayList<>();
    for (int i = 0; i < tel.length; i++) {
      String[] value = tel[i].split("_");
      if (value[1].length() == 0) {
        continue;
      }
      ContactTel contactTel = new ContactTel(Integer.parseInt(value[0]), value[1]);
      telList.add(contactTel);
    }
    contact.setTels(telList);

    // 서비스 객체 실행
    return contactService.add(contact);
  }
  /*
    // 1) 트랜젝션으로 묶어서 실행한 작업을 정의
    // => 스프링 프레임워크에서 정한 규칙에 따라 정의해야한다.(transactioncallback)
    class TransactionWorker implements TransactionCallback {
      @Override
      public Object doInTransaction(TransactionStatus status) {
        // 트랜잭션으로 묶어서 할 작업을 기술한다.
        contactDao.insert(contact);
        for (int i = 0; i < tel.length; i++) {

          contactDao.insertTel(new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1]));
        }
        return 1;
      }
    }

    // 2) 트랙잭션 작업을 수행한다.
    return transactionTemplate.execute(new TransactionWorker());

  }
   */

  @RequestMapping("/contact/get")
  public Object get(int no) {
    Contact contact = contactService.get(no);
    if (contact == null) {
      return "";
    }
    return contact;
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact, String[] tel) throws Exception {
    // 요청 파라미터 분석 및 가공
    ArrayList<ContactTel> telList = new ArrayList<>();
    for (int i = 0; i < tel.length; i++) {
      String[] value = tel[i].split("_");
      if (value[1].length() == 0) {
        continue;
      }
      // 연락처 변경에 경우 이미 연락처 번호를 알고 잇기 때문에
      // 전화 번호를 객체에 담을때 연락처 번호도 함께 저장한다.
      ContactTel contactTel = new ContactTel(contact.getNo(),Integer.parseInt(value[0]), value[1]);
      telList.add(contactTel);
    }
    contact.setTels(telList);

    // 서비스 객체 실행
    return contactService.update(contact);
  }

  @RequestMapping("/contact/delete")
  public Object delete(int no) throws Exception {
    return contactService.delete(no);
  }

}




