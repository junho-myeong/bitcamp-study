package com.eomcs.mylist.domain;

import java.sql.Date;

public class Board {
  String title;
  String content;
  int viewCount;
  java.sql.Date createdDate;

  public Board() {
    System.out.println("Board() 호출됨");
  }
  public String toCsvString() { // Comma Seperated value
    return String.format("%s,%s,%s,%s", //format사용법 알아야한다!(클래스 메서드 사용 파라미터 로만 사용했다)
        this.getTitle(),
        this.getContent(),
        this.getViewCount(),
        this.getCreatedDate());
  }
  public static Board valueOf(String csvStr) {
    //    String csvStr = buf.toString(); // 예) "홍길동,hong@test.com,010-1111-2222,비트캠프"
    String[] values = csvStr.split(","); 

    Board board = new Board();
    board.setTitle(values[0]); // 배열에 들어 잇는 각 항목을 객체 필드에 저장
    board.setContent(values[1]);
    board.setViewCount(Integer.valueOf(values[2]));
    board.setCreatedDate(Date.valueOf(values[3]));
    return board;
  }


  @Override
  public String toString() {
    return "Board [title=" + title + ", content=" + content + ", viewCount=" + viewCount
        + ", createdDate=" + createdDate + "]";
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public java.sql.Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(java.sql.Date createdDate) {
    this.createdDate = createdDate;
  }


}
