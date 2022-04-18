<%@page import="com.eomcs.mylist.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>MyList!</title>
  <link href="/css/common.css" rel="stylesheet">
</head>
<body>
<div class="container">

<div id="header">
<jsp:include page="/jsp/header.jsp"></jsp:include>
</div>

<div id="sidebar">
<jsp:include page="/jsp/sidebar.jsp"></jsp:include>
</div>

<div id="content">
<h1>게시글2</h1>
<a href="add">새 게시글</a>
<table id="x-board-table" border="1">
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>조회수</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>
<jsp:useBean id = "pageNo" type="java.lang.Integer" scope="request"></jsp:useBean>
<jsp:useBean id = "pageSize" type="java.lang.Integer" scope="request"></jsp:useBean>
<jsp:useBean id = "totalPageSize" type="java.lang.Integer" scope="request"></jsp:useBean>

<c:forEach var="board" items="${requestScope.list}">
  <tr>
    <td>${pageScope.board.no}</td> <!-- pageScope는 board객체를 가지고 잇는 임시 보관소이다. -->
    <td><a href='detail?no=${board.no}'>${board.title}</a></td> <!-- 실무에서는 보관소 이름도 지정하지 않는다. -->
    <td>${board.getWriter().getName()}></td>
    <td>${board.getViewCount()}</td>
    <td>${board.getCreatedDate()}></td>
  </tr>
</c:forEach>
</tbody>
</table>
<div>
<c:if test="${pageNo > 1}">
<%if (pageNo > 1) {%>
<a href="list?pageNo=<%=pageNo - 1%>&pageSize=<%=pageSize%>">[이전]</a>
</c:if>
<c:if test="${pageNo <= 1"}></c:if>
[이전]
${pageNo}
<c:if test="${pageNo < totalPageSize"}></c:if>
<a href="list?pageNo=${pageNo + 1}&pageSize=${pageSize}">[다음]</a>
<c:if test="${pageNo >= totalPageSize"}>
[다음]
</c:if>
</div>
</div>

<div id="footer">
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</div>

</div>
</body>
</html>
