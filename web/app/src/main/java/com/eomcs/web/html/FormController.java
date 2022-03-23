package com.eomcs.web.html;

import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FormController {

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
    return "ok"; 
  }
}
