<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="header.jsp" %>
  <body>
    <div class="container">
      <h1>
      	Member 확인
      </h1> 
      
      <hr>
      ${member.name} / ${member.userid}      
    </div>
  </body>
<%@ include file ="footer.jsp" %>