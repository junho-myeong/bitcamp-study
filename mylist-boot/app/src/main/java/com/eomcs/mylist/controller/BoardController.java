package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController 
public class BoardController {
  ArrayList boardList= new ArrayList();

  public BoardController() throws Exception {
    System.out.println("BoardController 호출됨!!");
    // 1) 주 작업 객체(concrete component) 준비
    FileReader in = new FileReader("board.csv");

    // 2) 한줄 단위로 데이터를 읽는 작업을 수행하는 데코레이터 준비
    BufferedReader in2 = new BufferedReader(in);

    StringBuilder buf = new StringBuilder(); // 이놈이 파일 읽는 일을 할수 잇는건 아니다!
    int c;
    while (true) {
      c = in2.read(); // 파일에서 한 문자를 읽는다!
      if (c == -1) // 만약 더이상 읽을 문자가 없다면 반복문을 종료한다.
        break;
      if (c == '\n') { // 만약 읽은 문자가 줄바꿈이라면, 지금까지 읽은 csv 데이터를 분석하여 Contact 객체에 담는다.!! // 파일에서 읽을 데이터를 담을 객체준비, 그리고 객체를 초기화 시킨다.
        boardList.add(Board.valueOf(buf.toString())); // 스태틱 메서드를 사용
        buf.setLength(0); // 다음데이터를 읽기 위해 버퍼를 초기화 시킨다.
      }else { // 문자를 읽을때 마다 buf에 일시 보관한다,
        buf.append((char) c);
      }
      //      System.out.print((char) c);
    }
    in2.close(); // 데코레이터를 close()하면 그 데코레이터와 연결된 모든 객체들도 close()된다
    // in.close();
  }

  @RequestMapping("/board/list")
  public Object list() {
    return boardList.toArray(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {

    board.setCreatedDate(new Date(System.currentTimeMillis()));
    boardList.add(board);
    return boardList.size();
  }


  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index < 0 || index >= boardList.size()) {
      return "";
    }
    Board board = (Board) boardList.get(index);
    board.setViewCount((board.getViewCount()+1));  //직접 변수에 접근하는게 아니고 메서드를 통해서 접근하는 방법이다.
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }

    Board old = (Board) boardList.get(index);
    board.setViewCount(old.getViewCount());
    board.setCreatedDate(old.getCreatedDate());

    return boardList.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }
    return boardList.remove(index) == null ? 0 : 1;
  }
  @RequestMapping("/board/save")
  public Object save() throws Exception {
    // 1) 주 작업 객체준비
    FileWriter out = new FileWriter("board.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 파일이 생성된다.

    // 2) 한 줄 단위로 출력하는 데코레이터 객체 준비
    PrintWriter out2 = new PrintWriter(out);
    Object[] arr = boardList.toArray();
    for (Object obj: arr) {
      Board board = (Board) obj;
      out2.println(board.toCsvString());
    }
    out2.close();
    //  out.close(); // 파일이랑 systemin 같은것들은 사용하고 닫아 주는 습관 들이기
    return arr.length;
  }
}




