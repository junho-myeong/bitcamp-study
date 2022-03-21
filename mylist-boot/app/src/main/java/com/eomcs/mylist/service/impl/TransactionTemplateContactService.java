package com.eomcs.mylist.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;
import com.eomcs.mylist.service.ContactService;

//@Service
public class TransactionTemplateContactService implements ContactService {
  @Autowired
  ContactDao contactDao;

  @Autowired
  TransactionTemplate transactionTemplate;

  @Override
  public int add(Contact contact) {

    // 익명클래스로 선언한다(왜? 클래스를 한번만 사용하기 때문에 그중에서 이부분은 람다문법 functional 인터페이스이다)
    return transactionTemplate.execute(status -> {
      contactDao.insert(contact);
      for (ContactTel tel : contact.getTels()) {
        tel.setContactNo(contact.getNo()); // 전화번호 입력 전에 자동 생성된 연락처 번호를 설정한다.
        contactDao.insertTel(tel);
      }
      return 1;
    });
  }

  @Override
  public List<Contact> list() {
    List<Contact> contacts = contactDao.findAll();
    for (Contact contact : contacts) {
      contact.setTels(contactDao.findTelByContactNo(contact.getNo()));
    }
    return contacts;
  }

  @Override
  public Contact get(int no) {
    Contact contact = contactDao.findByNo(no);
    if (contact != null) {
      contact.setTels(contactDao.findTelByContactNo(no));
    }
    return contact;
  }

  @Override
  public int update(Contact contact) {
    //    // 1) 트랜잭션으로 묶어서 실행할 작업을 스프링 규칙에 따라 정의한다.
    //    class ContactUpdateTransaction implements TransactionCallback<Integer> {
    //
    //      @Override
    //      public Integer doInTransaction(TransactionStatus status) {
    //        int count = contactDao.update(contact);
    //        if (count > 0) {
    //          contactDao.deleteTelByContactNo(contact.getNo()); // 전화 번호 변경 전에 기존 전화 번호를 모두 삭제한다.
    //          for (ContactTel tel : contact.getTels()) {
    //            contactDao.insertTel(tel); // 전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
    //          }
    //        }
    //        return count;
    //      }
    //    }
    //    // 2) 트랜잭션을 실행한다.
    //    return transactionTemplate.execute(new ContactUpdateTransaction());
    //  }


    // 1) (익명클래스)트랜잭션으로 묶어서 실행할 작업을 스프링 규칙에 따라 정의한다.
    //    TransactionCallback<Integer> contactUpdateTransaction =  new TransactionCallback<Integer> (){
    //
    //      @Override
    //      public Integer doInTransaction(TransactionStatus status) {
    //        int count = contactDao.update(contact);
    //        if (count > 0) {
    //          contactDao.deleteTelByContactNo(contact.getNo()); // 전화 번호 변경 전에 기존 전화 번호를 모두 삭제한다.
    //          for (ContactTel tel : contact.getTels()) {
    //            contactDao.insertTel(tel); // 전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
    //          }
    //        }
    //        return count;
    //      }
    //
    //        // 2) 트랜잭션을 실행한다.
    //      };
    //      return transactionTemplate.execute(new contactUpdateTransaction);


    // 1) (익명클래스)트랜잭션으로 묶어서 실행할 작업을 스프링 규칙에 따라 정의한다.


    // 2) 트랜잭션을 실행한다.

    //    return transactionTemplate.execute(new TransactionCallback<Integer> (){
    //
    //      @Override
    //      public Integer doInTransaction(TransactionStatus status) {
    //        int count = contactDao.update(contact);
    //        if (count > 0) {
    //          contactDao.deleteTelByContactNo(contact.getNo()); // 전화 번호 변경 전에 기존 전화 번호를 모두 삭제한다.
    //          for (ContactTel tel : contact.getTels()) {
    //            contactDao.insertTel(tel); // 전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
    //          }
    //        }
    //        return count;
    //      }
    //      });

    return transactionTemplate.execute(status -> {
      int count = contactDao.update(contact);
      if (count > 0) {
        contactDao.deleteTelByContactNo(contact.getNo()); // 전화 번호 변경 전에 기존 전화 번호를 모두 삭제한다.
        for (ContactTel tel : contact.getTels()) {
          contactDao.insertTel(tel); // 전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
        }
      }
      return count;

    });
  }


  @Override
  public int delete(int no) {
    return transactionTemplate.execute(status -> {
      contactDao.deleteTelByContactNo(no);
      return contactDao.delete(no);
    });
  }
}

