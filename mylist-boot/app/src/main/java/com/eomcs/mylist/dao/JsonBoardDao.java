package com.eomcs.mylist.dao;

import java.io.File;
import com.eomcs.mylist.domain.Board;
import com.fasterxml.jackson.databind.ObjectMapper;


//@Repository 
// - 이 애노테이션을 붙여 표시해 두면 SpringBoot가 이 클래스의 객체를 자동 생성한다.
// - 또한 이 객체를 원하는 곳에 자동으로 주입한다.
// - 이 애노테이션을 붙이는 이유는 이 클래스는 데이터 저장소라는 것을 나가내기 위함이다.
public class JsonBoardDao extends AbstractBoardDao {

  String filename = "boards.json";

  public JsonBoardDao() {
    try {
      ObjectMapper mapper = new ObjectMapper();
      boardList.addAll(mapper.readValue(new File(filename), Board[].class));

    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생!");
    }
  }

  @Override
  protected void save() throws Exception {

    // json 형태로 출력할 일을 하는 클래스
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), boardList.toArray());
  }
}











