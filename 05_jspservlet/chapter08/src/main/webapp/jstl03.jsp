<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<%@ include file ="header.jsp" %>
  <body>
    <div class="container">
      <h1>
      	c:forEach 라이브러리 실습
      </h1> 
      <%
      	int[] num ={ 1,2,3,4,5,6,7,8,9,10};
      request.setAttribute("myArray", num);      
      %>
      <c:forEach var="n" items="${myArray}">
      	<c:out value="${n}"/>
      </c:forEach>
      <br>
      <c:forEach var="n" items="${myArray}" begin="0" end="6">
      	<c:out value="${n}"/>
      </c:forEach>
    </div>
<%@ include file ="footer.jsp" %>