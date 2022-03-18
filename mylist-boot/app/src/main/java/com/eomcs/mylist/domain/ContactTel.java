package com.eomcs.mylist.domain;

public class ContactTel {
  int no; // 전화 번호 고유번호
  int contactNo; // 누구 전화 번호인지 저장
  int telTypeNO; // 전화번호 유형
  String tel; // 전화번호 저장

  public ContactTel() {

  }

  public ContactTel(int contactNo, int telTypeNO, String tel) {
    this.contactNo = contactNo;
    this.telTypeNO = telTypeNO;
    this.tel = tel;
  }
  @Override
  public String toString() {
    return "ContactTel [no=" + no + ", contactNo=" + contactNo + ", telTypeNO=" + telTypeNO
        + ", tel=" + tel + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getContactNo() {
    return contactNo;
  }
  public void setContactNo(int contactNo) {
    this.contactNo = contactNo;
  }
  public int getTelTypeNO() {
    return telTypeNO;
  }
  public void setTelTypeNO(int telTypeNO) {
    this.telTypeNO = telTypeNO;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }




}
