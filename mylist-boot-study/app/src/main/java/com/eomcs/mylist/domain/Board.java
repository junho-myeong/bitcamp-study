package com.eomcs.mylist.domain;

import lombok.Data;

@Data
public class Board {
  int no;
  String title;
  String content;
  int viewCount;
  java.sql.Date createdDate;

  //  외래키
  Member Writer;
}
