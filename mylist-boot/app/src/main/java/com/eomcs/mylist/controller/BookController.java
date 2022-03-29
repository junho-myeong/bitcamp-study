package com.eomcs.mylist.controller;

import java.io.File;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.mylist.dao.BookDao;
import com.eomcs.mylist.domain.Book;

@RestController 
public class BookController {
  @Autowired
  BookDao bookDao;

  @RequestMapping("/book/list")
  public Object list() {
    return bookDao.findAll(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book, MultipartFile file) throws Exception {
    // 파일이 업로드 되었다면 저장한다.
    try {
      // 저장된 파일명을 도메인 객체에 설정한다.
      book.setPhoto(saveFile(file));
      return bookDao.insert(book);
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }
  }


  @RequestMapping("/book/get")
  public Object get(int no) {
    Book book = bookDao.findByNo(no);
    if (book == null) {
      return "";
    }
    return book;
  }

  @RequestMapping("/book/update")
  public Object update(Book book, MultipartFile file) throws Exception {
    try {
      // 저장된 파일명을 도메인 객체에 설정한다.
      book.setPhoto(saveFile(file));
      return bookDao.update(book);
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }
  }

  @RequestMapping("/book/delete")
  public Object delete(int no) throws Exception {
    return bookDao.delete(no);
  }

  private String saveFile(MultipartFile file) throws Exception {
    if (file != null & file.getSize() > 0) {
      // 파일 저장할 때 사용할 파일명을 준비한다.
      String filename = UUID.randomUUID().toString(); 

      // 파일명의 확장자를 알아 낸다.
      int dotIndex = file.getOriginalFilename().lastIndexOf(".");
      if (dotIndex != -1) {
        filename += file.getOriginalFilename().substring(dotIndex);
      }
      // 파일을 지정된 폴더에 저장한다.
      File photoFile = new File("./upload/book/" + filename);
      file.transferTo(photoFile.getCanonicalFile());

      return filename;
    } else {
      return null;
    }
  }
}




