package com.eomcs.mylist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.domain.Board;


//@Repository 
// - 이 애노테이션을 붙여 표시해 두면 SpringBoot가 이 클래스의 객체를 자동 생성한다.
// - 또한 이 객체를 원하는 곳에 자동으로 주입한다.(BoardDao를 원하는 곳에 자동주입)
// - 이 애노테이션을 붙이는 이유는 이 클래스는 데이터 저장소라는 것을 나가내기 위함이다.
@Repository
public class jdbcBoardDao implements BoardDao {

  public jdbcBoardDao() {
    System.out.println("jdbcBoard객체생성");
  }

  @Override
  public int countAll() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<Board> findAll() throws Exception {
    try (Connection con = DriverManager.getConnection( 
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement( 
            "select board_no,title,created_date,view_count from ml_board order by board_no desc");
        ResultSet rs = stmt.executeQuery()) {

      ArrayList<Board> arr = new ArrayList<>();
      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_no"));
        board.setTitle(rs.getString("title"));
        board.setCreatedDate(rs.getDate("created_date"));
        board.setViewCount(rs.getInt("view_count"));
        arr.add(board);
      }
      return arr;
    }
  }

  @Override
  public int insert(Board board) throws Exception {
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt =
            con.prepareStatement("insert into ml_board(title,content) values(?,?)");) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());

      return stmt.executeUpdate();
    }
  }

  @Override
  public Board findByNo(int no) throws Exception {
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement( //
            "select board_no,title,content,created_date,view_count from ml_board where board_no=?")) {

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next())
          return null;

        Board board = new Board();
        board.setNo(rs.getInt("board_no"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setCreatedDate(rs.getDate("created_date"));
        board.setViewCount(rs.getInt("view_count"));
        return board;
      }
    }
  }

  @Override
  public int update(Board board) throws Exception {
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement( //
            "update ml_board set title = ?, content = ? where board_no = ?")) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getNo());

      return stmt.executeUpdate();
    }
  }

  @Override
  public int delete(int no) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int increaseViewCount(int no) throws Exception {
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement( //
            "update ml_board set view_count = view_count + 1 where board_no = ?")) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();
    }
  }


}













