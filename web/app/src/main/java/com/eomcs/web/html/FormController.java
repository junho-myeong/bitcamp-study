package com.eomcs.web.html;

import java.io.File;
import java.util.HashMap;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FormController {

  @Autowired
  ServletContext sc; // 서버에 배포된 웹 애플리케이션에 정보를 다루는 객체

  @RequestMapping("/html/form/exam01")
  public Object exam01() {
    return "Hello";
  }

  @RequestMapping("/html/form/exam02")
  public Object exam02(String name, int age) {
    HashMap<String,Object> map = new HashMap<>();
    map.put("name", name);
    map.put("age", age);

    return map; // JSON형식으로 바꿔서 리턴한다
  }

  @RequestMapping("/html/form/exam11")
  public Object exam03(String name, int age, MultipartFile photo) {
    System.out.println(name);
    System.out.println(age);
    System.out.println(photo.getOriginalFilename());

    try {
      File photoFile = new File("c:/upload/" + photo.getOriginalFilename());
      photo.transferTo(photoFile);
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }

    return "ok"; 
  }

  @RequestMapping("/html/form/exam12")
  public Object exam04(String name, int age, MultipartFile[] photo) {
    System.out.println(name);
    System.out.println(age);

    for (MultipartFile part : photo) {
      try {
        File photoFile = new File("c:/upload/" + part.getOriginalFilename());
        part.transferTo(photoFile);
      } catch (Exception e) {
        e.printStackTrace();
        return "error";
      }
    }
    return "ok"; 
  }

  @RequestMapping("/html/form/exam21")
  public Object exam21(String name, int age) {
    System.out.println(name);
    System.out.println(age);
    //    System.out.println(photo.getOriginalFilename());
    //
    //    try {
    //      File photoFile = new File("c:/upload/" + photo.getOriginalFilename());
    //      photo.transferTo(photoFile);
    //    } catch (Exception e) {
    //      e.printStackTrace();
    //      return "error";
    //    }

    return "ok"; 
  }
}
