// 인터페이스 구현하기
package com.eomcs.mylist.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.eomcs.mylist.domain.Board;

@Mapper 
// => Mybatis에서 DAO구현체를 자동으로 생성한다.
// => DAO구현체가 사용할 SQL Mapper 파일의 위치는 인터페이스 패키지 경로및 이름이 일치해야한다.
//      예) com/eomcs/mylist/dao/BoardDao.xml
// => 인터페이스에 메서드를 호출될때 사용할 SQL ID는 메서드 이름과 일치해야한다.
// 예) <select id="countAll">...</select>
//
public interface BoardDao {

  // 인터페이스는 객체의 메서드 호출 규칙을 정의하는 것이기 때문에
  // 메서드를 작성할 때 메서드 몸체(method body)를 작성하지 말아야한다.
  // 메서드 바디가 없는 메서드를 "추상 메서드(abstract method)"라 부른다.

  // 인터페이스에 모든 메서드는 기본적으로 public 이다 그래서 생략 가능하다.
  // 왜냐?
  // => 모든 규칙은 공개 되어야 사람들이 알기 때문이다.
  int countAll();

  List<Board> findAll();

  int insert(Board board);

  Board findByNo(int no);

  int update(Board board);

  int delete(int no);

  int increaseViewCount(int no);


}
