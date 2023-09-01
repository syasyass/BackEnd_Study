<!-- jsp 시작시 필요한 부분 -->
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="header.jsp" %>
<%
	Date d = new Date();
%>
  <body>
    <div class="container">
      <h1>
      	Glory에 오신것을 환영합니다. 현재 시간: <%=d.toLocaleString()%>
      </h1> 
      <a href="about.jsp">about</a>
    </div>
  </body>
<%@ include file ="footer.jsp" %>