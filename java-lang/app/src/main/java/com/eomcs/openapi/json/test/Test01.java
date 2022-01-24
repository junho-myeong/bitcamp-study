package com.eomcs.openapi.json.test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test01 {

  public static void main(String[] args) throws Exception {
    String jsonStr = "{\"name\":\"소보로\",\"maker\":\"안데르센\"}";

    ObjectMapper mapper = new ObjectMapper();

    // 두번째 파라미터에 클래스 정보를 넘겨줘야한다.
    System.out.println(mapper.readValue(jsonStr, Bread.class));
  }

}
