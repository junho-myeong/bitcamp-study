package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class My1Controller {
  String[] universities = new String[10];
  int size = 0;
  int updateIdx;
  @RequestMapping("/my1/list")
  public Object list() {
    //    String[] universities = {
    //        "서울대학교,1등급,1등급,1등급,1등급,1등급",
    //        "연세대학교,1등급,1등급,1등급,1등급,1등급",
    //        "고려대학교,1등급,1등급,1등급,1등급,1등급",
    //        "성균관대학교,1등급,1등급,1등급,1등급,1등급"
    //    };
    String[] arr = new String[size];
    for (int i = 0 ; i < size; i++) {
      arr[i] = universities[i];
    }
    return arr;
  }
  @RequestMapping("/my1/add")
  public Object add(String uName, String koreanRate, String mathRate, String foreignRate,String sienceRate1, String sienceRate2) {
    String university = uName + "," + koreanRate + "," + mathRate + "," + foreignRate + "," + sienceRate1 +"," + sienceRate2;
    universities[size++] = university;
    return size;
  }
  @RequestMapping("my1/get")
  public Object get(String uName) {
    for (int i = 0; i < size; i++) {
      if(universities[i].split(",")[0].equals(uName)) {
        updateIdx = i;
        return universities[i];
      }
    }
    return "";
  }
  @RequestMapping("my1/update")
  public Object update(String uName, String koreanRate, String mathRate, String foreignRate,String sienceRate1, String sienceRate2) {
    universities[updateIdx] = uName + "," + koreanRate + "," + mathRate + "," + foreignRate + "," + sienceRate1 +"," + sienceRate2;
    return updateIdx;
  }
  @RequestMapping("my1/delete")
  public Object delete() {
    for(int i = updateIdx+1; i < size; i++) {
      universities[i-1] = universities[i];
    }
    size--;
    return 1;
  }
}
