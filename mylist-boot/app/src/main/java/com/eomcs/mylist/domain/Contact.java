package com.eomcs.mylist.domain;

public class Contact {
  int no;
  String name;
  String email;
  String tel;
  String company;


  @Override
  public String toString() {
    return "Contact [no=" + no + ", name=" + name + ", email=" + email + ", tel=" + tel
        + ", company=" + company + "]";
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getCompany() {
    return company;
  }
  public void setCompany(String company) {
    this.company = company;
  }



  /*
  / 데이터를 저장할 테이블 생성
  create table ml_contact(
      contact_no int not null,
      name varchar(50) not null,
      tel varchar(20) not null,
      email varchar(50) not null,
      company varchar(50)
      );
   */

  /*
  alter table ml_contact
    add constraint ml_contact_pk primary key(contact_no),
    modify column contact_no int not null auto_increment;
   */


}
