<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="header.jsp" %>
<%
	String[] names = (String [])request.getAttribute("names");
%>
  <body>
    <div class="container">
      <h1>
      	목록보기
      </h1>
      <% for(String name: names){ %>
      	<%=name%> <br>
      <% } %>
    </div>
  </body>
<%@ include file ="footer.jsp" %>