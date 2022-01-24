package com.eomcs.openapi.json.test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test02 {

  public static void main(String[] args) throws Exception {
    // JSON 배열을 만드는거잇다.
    String jsonStr = "[{\"name\":\"소보로\",\"maker\":\"안데르센\"},{\"name\":\"단팥빵\",\"maker\":\"안데르센\"}]";

    ObjectMapper mapper = new ObjectMapper();

    // 두번째 파라미터에 클래스 정보를 넘겨줘야한다.(두번째 파라미터도 그에 맞는 클래스정보를 달라고해야한다.)
    Bread[] objs = mapper.readValue(jsonStr, Bread[].class);
    for (Bread obj : objs) {
      System.out.println(obj);
    }

  }

}
