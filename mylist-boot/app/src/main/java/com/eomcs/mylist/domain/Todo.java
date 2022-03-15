package com.eomcs.mylist.domain;

public class Todo {
  int no;
  String title;
  boolean done;
  @Override
  public String toString() {
    return "Todo [no=" + no + ", title=" + title + ", done=" + done + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
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




  /*
  / 데이터를 저장할 테이블 생성
  create table ml_todo(
      todo_no int not null,
      title varchar(255) not null,
      done boolean default false
      );
   */

  /*
  alter table ml_todo
    add constraint ml_contact_pk primary key(todo_no),
    modify column todo_no int not null auto_increment;
   */

}
