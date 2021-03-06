package com.eomcs.mylist.controller;

import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@RestController 
public class BoardController {

  // log를 출력하는 도구를 준비한다.
  private final static Logger log = LoggerFactory.getLogger(BoardController.class); // 이제 로그를 남길때 파라미터 클래스 이름으로 로그를 남긴다.

  @Autowired
  BoardService boardService;

  @RequestMapping("/board/list")
  public Object list() {
    log.error("error!!");
    log.warn("warn!!");
    log.info("info!!");
    log.debug("debug!");
    log.trace("trace!!");
    return new ResultMap().setStatus(SUCCESS).setData(boardService.list());
  }

  @RequestMapping("/board/add")
  public Object add(Board board, HttpSession session) {
    log.info("게시글 등록!"); // 운영자가 확인하기를 원하는 정보
    log.debug(board.toString()); // 개발자가 확인하기 원하는 정보
    // interceptor 때문에 로그인 검사를 여기서 하지 않고 무조건 로그인 된 상태가 들어온다
    // 즉 prehandle()이 true일 때만 여기로 넘어온다
    Member member = (Member) session.getAttribute("loginUser");
    board.setWriter(member);
    boardService.add(board);
    return new ResultMap().setStatus(SUCCESS);
  }


  @RequestMapping("/board/get")
  public Object get(int no) {
    Board board = boardService.get(no);
    if (board == null) {
      return new ResultMap().setStatus(FAIL).setData("해당 번호의 게시글이 없습니다.");
    }
    return new ResultMap().setStatus(SUCCESS).setData(board);
  }

  @RequestMapping("/board/update")
  public Object update(Board board, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    // interceptor 때문에 로그인 검사를 여기서 하지 않고 무조건 로그인 된 상태가 들어온다
    // 즉 prehandle()이 true일 때만 여기로 넘어온다

    board.setWriter(member);
    int count = boardService.update(board);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }

  @RequestMapping("/board/delete")
  public Object delete(int no, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    // interceptor 때문에 로그인 검사를 여기서 하지 않고 무조건 로그인 된 상태가 들어온다
    // 즉 prehandle()이 true일 때만 여기로 넘어온다

    Board board = new Board();
    board.setNo(no);
    board.setWriter(member);

    int count = boardService.delete(board);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }
}




