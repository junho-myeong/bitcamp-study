package com.eomcs.mylist.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;


//@Repository 
// - 이 애노테이션을 붙여 표시해 두면 SpringBoot가 이 클래스의 객체를 자동 생성한다.
// - 또한 이 객체를 원하는 곳에 자동으로 주입한다.(BoardDao를 원하는 곳에 자동주입)
// - 이 애노테이션을 붙이는 이유는 이 클래스는 데이터 저장소라는 것을 나가내기 위함이다.
@Repository
public class BoardDaoImpl implements BoardDao {

  @Autowired
  SqlSessionFactory sqlSessionFactory; // => Mybatis: SQL 실행 도구를 만들어주는 객체

  public BoardDaoImpl() {
    System.out.println("jdbcBoard객체생성");
  }

  @Override
  public int countAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.selectOne("BoardDao.sql5");
    }
  }

  @Override
  public List<Board> findAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.selectList("BoardDao.sql1");
    }
  }

  @Override
  public int insert(Board board){
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.insert("BoardDao.sql3", board);
    }
  }

  @Override
  public Board findByNo(int no){
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      System.out.println(sqlSession.getClass().getName());
      return sqlSession.selectOne("BoardDao.sql2", no);
    }
  }

  @Override
  public int update(Board board) {
    try(SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.insert("BoardDao.sql4", board);
      //insert,update,delete는 insert태그로해도 상관없다.
    }
  }

  @Override
  public int delete(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.delete("BoardDao.sql6", no);
    }
  }

  @Override
  public int increaseViewCount(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.update("BoardDao.sql7", no);
    }
  }


}













