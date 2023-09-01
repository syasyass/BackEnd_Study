<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="header.jsp" %>
  <body>
    <div class="container">
      <h1>
      	VO 확인
      </h1> 
      <hr>
      ${user.name} /
      ${user.userid}
    </div>
<%@ include file ="footer.jsp" %>