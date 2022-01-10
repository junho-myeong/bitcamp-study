package com.eomcs.mylist.domain;

public class Todo {
  String title;
  boolean done;

  public String toCsvString() { // Comma Seperated value
    return String.format("%s,%s", //format사용법 알아야한다!(클래스 메서드 사용 파라미터 로만 사용했다)
        this.getTitle(),
        this.isDone());
  }

  public Todo(String csvStr) {
    //    String csvStr = buf.toString(); // 예) "홍길동,hong@test.com,010-1111-2222,비트캠프"
    String[] values = csvStr.split(","); 

    this.setTitle(values[0]); // 배열에 들어 잇는 각 항목을 객체 필드에 저장
    this.setDone(Boolean.parseBoolean(values[1]));
  }

  public Todo() {
    System.out.println("Todo() 호출됨");
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public boolean isDone() {
    return done;
  }
  public void setDone(boolean done) {
    this.done = done;
  }
  @Override
  public String toString() {
    return "Todo [title=" + title + ", done=" + done + "]";
  }


}
