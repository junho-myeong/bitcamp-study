package com.eomcs.mylist.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController 
public class ContactController {

  @Autowired
  ContactDao contactDao;


  @RequestMapping("/contact/list")
  public Object list() {
    return contactDao.findAll(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) throws Exception {
    //    System.out.println(contact);
    contactDao.insert(contact);
    return contactDao.countAll();
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    Contact contact = contactDao.findByEmail(email);
    return contact != null ? contact : "";
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) throws Exception {
    return contactDao.update(contact);
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) throws Exception {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    contactDao.delete(index);
    return 1;
  }


}




