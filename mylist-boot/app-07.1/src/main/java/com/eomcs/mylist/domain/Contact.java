package com.eomcs.mylist.domain;

public class Contact {
  // information Expert?
  // =>
  // 여기서 중요한것은 Contact class가 데이터 전문가 이다.
  // 그래서 데이터 관련된 메서드 같은것은 여기에 넣어야 다른 클래스에서 이 
  // 객체를 사용할때 유지 보수가 쉽다.
  String name;
  String email;
  String tel;
  String company;

  public Contact() {
    System.out.println("Contact() 호출됨");
  }

  // 적용 기술:
  // 인스턴스 메서드
  // => 특정 인스턴스를 사용한다면 인스턴스 메서드로 만들라!!
  // GRASP의 information Expert 
  // => 데이터를 가공하는 일은 데이터를 가지고 잇는 클래스에 둬야한다.
  public String toCsvString() { // Comma Seperated value
    return String.format("%s,%s,%s,%s", //format사용법 알아야한다!(클래스 메서드 사용 파라미터 로만 사용했다)
        this.getName(),
        this.getEmail(),
        this.getTel(),
        this.getCompany()); 
  }
  public Contact(String csvStr) {
    //    String csvStr = buf.toString(); // 예) "홍길동,hong@test.com,010-1111-2222,비트캠프"
    String[] values = csvStr.split(","); 

    this.setName(values[0]); // 배열에 들어 잇는 각 항목을 객체 필드에 저장
    this.setEmail(values[1]);
    this.setTel(values[2]);
    this.setCompany(values[3]);
  }


  // 적용기술:
  // => 스태틱 메서드: 특정 인스턴스에 종속 되지 않고 사용하는 메서드
  // => GOF의 ' Factory Method' 패턴
  //    객체 생성 과정이 복잡할 경우 new명령을 통해 직접 객체를 생성하는 대신에 
  //    메서드를 통행 객체를 리턴받는다.
  //    이렇게 객체를 만들어 주는 메서드를 "공장 메서드(factory method)"라 부른다.
  //    보통 스태틱 메서드로 정의한다.
  // => 즉 기본적으로 우리가 넣어 줘야 하는 메서드 이다
  public static Contact valueOf(String csvStr) {
    //    String csvStr = buf.toString(); // 예) "홍길동,hong@test.com,010-1111-2222,비트캠프"
    String[] values = csvStr.split(","); 
    Contact contact = new Contact();
    contact.setName(values[0]); // 배열에 들어 잇는 각 항목을 객체 필드에 저장
    contact.setEmail(values[1]);
    contact.setTel(values[2]);
    contact.setCompany(values[3]);
    return contact;
  }

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
