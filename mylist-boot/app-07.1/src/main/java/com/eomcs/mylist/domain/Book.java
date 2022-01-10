package com.eomcs.mylist.domain;

import java.sql.Date;

// 다른 패키지에서 사용하기 위해 public으로 클래스를 공개한다.
public class Book {
  String title;
  String author;
  String press;
  int page;
  int price;
  Date readDate;
  String feed;

  // getter 와 setter 가 없으면 스피링 부트는 객체를 생성한후 만들어진 인스턴스에 
  // 값을 넣을 방법이 없기 때문에 꼭 setter가 잇어야 한다. 즉 인스턴스만 잇고 그 
  // 값을 넣을 방법이 없다라는 뜻이다.
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public String getPress() {
    return press;
  }
  public void setPress(String press) {
    this.press = press;
  }
  public int getPage() {
    return page;
  }
  public void setPage(int page) {
    this.page = page;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public java.sql.Date getReadDate() {
    return readDate;
  }
  public void setReadDate(java.sql.Date readDate) {
    this.readDate = readDate;
  }
  public String getFeed() {
    return feed;
  }
  public void setFeed(String feed) {
    this.feed = feed;
  }
  @Override
  public String toString() {
    return "Book [title=" + title + ", author=" + author + ", press=" + press + ", page=" + page
        + ", price=" + price + ", readDate=" + readDate + ", feed=" + feed + "]";
  }




}
