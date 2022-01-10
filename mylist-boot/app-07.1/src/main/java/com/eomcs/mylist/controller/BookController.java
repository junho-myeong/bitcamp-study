package com.eomcs.mylist.controller;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController 
public class BookController {
  ArrayList bookList = new ArrayList();

  public BookController() {
    System.out.println("BoardController 호출됨!!");
  }

  @RequestMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  // 여기서 add라는 함수는 book 이라는 객체를 원한다.
  // 그래서 쿼리 스트링으로 값을 넘겨 줄때
  // book 이라는 인스턴스를 넘저 만들고
  // 그 변수에 대해 값을 넣을려면 setter 메서드가 꼭 잇어야 한다.
  @RequestMapping("/book/add")
  public Object add(Book book) {
    book.setReadDate(new Date(System.currentTimeMillis()));
    bookList.add(book);
    return bookList.size();
  }


  @RequestMapping("/book/get")
  public Object get(int index) {
    if (index < 0 || index >= bookList.size()) {
      return "";
    }
    Book book= (Book) bookList.get(index);
    return book;
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    Book old = (Book) bookList.get(index);
    book.setReadDate(old.getReadDate());

    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.remove(index) == null ? 0 : 1;
  }
}




