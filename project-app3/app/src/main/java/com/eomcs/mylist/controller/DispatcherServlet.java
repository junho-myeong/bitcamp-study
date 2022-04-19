package com.eomcs.mylist.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// add, update는 post요청으로 많이하고,
// 나머지 delete 같은것은 get요청을 많이한다.
// 그래서 이 프론트 컨트롤러는 둘다 사용해야한다.
@WebServlet("/app/*")
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {

  // HttpServlet에서 추가한 메서드 이다,
  // 단, 이것을 호출하는것은 Servlet에서 만든 service란 메서드가 이 밑에 함수를 호출하는것이다.
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String controllerPath = request.getPathInfo();

    try {
      response.setContentType("text/html; charset=UTF-8");
      RequestDispatcher 요청배달자 = request.getRequestDispatcher(controllerPath); // /app/까지 저장한고
      요청배달자.include(request, response); // /app/밑에것중에 요청으로 들어온거 실행 해달라는 뜻이다.

      Exception exception = (Exception) request.getAttribute("exception");
      if (exception != null) {
        throw exception; 
      }

      String viewUrl = (String) request.getAttribute("viewUrl");
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
      } else {
        request.getRequestDispatcher(viewUrl).include(request, response);        
      }
    } catch (Exception e) {
      if (request.getAttribute("exception") == null) {
        request.setAttribute("exception", e);
      }
      request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
  }
}
