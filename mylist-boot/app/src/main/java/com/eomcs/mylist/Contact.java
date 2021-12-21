package com.eomcs.mylist;

public class Contact {
  String name;
  String email;
  String tel;
  String company;

  // 한줄에 문자열로 만들어 주는 메서드 이다.
  @Override
  public String toString() {
    return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + ", company=" + company
        + "]";
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
}
