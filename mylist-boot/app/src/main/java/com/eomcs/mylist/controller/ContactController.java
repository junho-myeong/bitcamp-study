package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;

@RestController 
public class ContactController {

  @Autowired
  ContactDao contactDao;


  @RequestMapping("/contact/list")
  public Object list() {
    return contactDao.findAll(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact, String[] tel) throws Exception {
    //    System.out.println(contact);
    //    System.out.println();
    contactDao.insert(contact);
    for (int i = 0 ; i < tel.length ; i++) {
      String[] values = tel[i].split(",");
      contactDao.insertTel(new ContactTel(contact.getNo(),Integer.parseInt(values[0]), values[1]));
    }


    return 1;
  }


  @RequestMapping("/contact/get")
  public Object get(int no) {
    Contact contact = contactDao.findByNo(no);
    return contact != null ? contact : "";
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) throws Exception {
    return contactDao.update(contact);
  }

  @RequestMapping("/contact/delete")
  public Object delete(int no) throws Exception {
    return contactDao.delete(no);
  }


}




