package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;

@RestController 
public class BoardController {

  // BoardDao 규칙에 따라 만든 인터페이스는 레퍼런스에 담을수 잇다.
  // BoardDao boardDao = new JsonBoardDao();
  // 밑에 애노테이션을 사용하면 구현체를 바꿀 때마다 객체를 다르게 생성할 필요없이 
  // 자동으로 교체해준다.

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면,
  // SpringBoot가 BoardController 객체를 만들때(생성자 호출될때)
  // BoardDao 구현체를 찾아 자동으로 주입한다.
  // 이렇게 하면 좋은 점은 기존의 코드를 건드리지 않아도 된다는 것이다.
  // 이게 바로 "dependency injection" 이라고 부른다
  @Autowired/*(required = false) 자동으로 주입하는것을 하지 않는다는 뜻이다*/
  BoardDao boardDao; // 실제로 BoardDao인터페이스를 구현한 인스턴스 주소가 담긴다

  @RequestMapping("/board/list")
  public Object list() {
    return boardDao.findAll(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    return boardDao.insert(board);
  }


  @RequestMapping("/board/get")
  public Object get(int no) {
    Board board = boardDao.findByNo(no);
    if (board == null) {
      return "";
    }
    boardDao.increaseViewCount(no);
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(Board board) {
    return boardDao.update(board);
  }

  @RequestMapping("/board/delete")
  public Object delete(int no) {
    return boardDao.delete(no);
  }
}




