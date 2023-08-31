<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="header.jsp" %>
  <body>
    <div class="container">
      	 <h1>로그인 입력 파라미터 출력</h1> 
      <%
      	String userid = request.getParameter("userid");
      	String Password = request.getParameter("Password");					
      %>
      아이디값: <%= userid %> <br>
      비밀번호: <%= Password %> <br>
    </div>
  </body>
<%@ include file ="footer.jsp" %>