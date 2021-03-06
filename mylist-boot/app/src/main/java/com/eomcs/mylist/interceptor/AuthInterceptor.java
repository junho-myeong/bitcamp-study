package com.eomcs.mylist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.eomcs.mylist.controller.ResultMap;
import com.eomcs.mylist.domain.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

// 사용자 인증 여부를 검사하는 인터셉터
public class AuthInterceptor implements HandlerInterceptor {

  private final static Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    log.debug("prehandle() 호출됨!");

    // 로그인 여부 검사
    HttpSession session = request.getSession();
    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser == null) {
      // 로그인을 하지 않았으면 오류 메시지를 JSON 형식으로 직접 응답한다.
      response.setContentType("application.json;charset=UTF-8");
      response.getWriter().write(new ObjectMapper().writeValueAsString(new ResultMap()
          .setStatus(ResultMap.FAIL)
          .setData("로그인 하지 않았습니다")));
      return false; // 페이지 컨트롤러를 실행하지 말고 즉시 응답하라!(이 상태면 Despatcher servlet에 빈 문자열을 보낸다.)
    }

    return true; // 로그인 된 상태라면, 계속 진행하라! (요청한 페이지 컨트롤러의 메서드를 호출하라!)
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    log.debug("posthandle() 호출됨!");
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }
}
