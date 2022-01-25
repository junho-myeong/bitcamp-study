package com.eomcs.mylist.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import com.eomcs.mylist.domain.Board;

public class CsvBoardDao extends AbstractBoardDao { // variables initializer

  public CsvBoardDao(){
    try {
      BufferedReader in = new BufferedReader(new FileReader("boards.csv"));

      String csvStr;
      while ((csvStr = in.readLine()) != null) {
        boardList.add(Board.valueOf(csvStr)); 
      }
      in.close();
    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩중 오류발생");
    }


  }
  @Override
  protected void save() throws Exception {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("boards.csv")));

    Object[] arr = boardList.toArray();
    for (int i = 0; i < boardList.size(); i++) {
      Board board = (Board) boardList.get(i);
      out.println(board.toCsvString());
    }
    out.flush(); // 찌끄래기도 다 출력하도록 요구하는것이다.
    out.close();
  }

}
