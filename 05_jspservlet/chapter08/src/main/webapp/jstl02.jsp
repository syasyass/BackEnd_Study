<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<%@ include file ="header.jsp" %>
  <body>
    <div class="container">
      <h1>c:if 태그</h1> 
      <hr>
      <c:set var="myColor" value="빨강" />
      <c:if test="${myColor == '빨강'}">
      색상은 빨강색이다.
      </c:if>      
      <c:if test="${myColor != '빨강'}">
      색상은 빨강색이 아닙니다.
      </c:if>    
      
      <h1>c:choose 태그</h1> 
      <c:set var="grade" value="70" />
      <c:choose>
      	<c:when test="${ grade >= 90 }">
      		학점은 A 이다.
      	</c:when>
      	<c:when test="${ grade >= 80 }">
      		학점은 B 이다.
      	</c:when>
      	<c:when test="${ grade >= 70 }">
      		학점은 C 이다.
      	</c:when>
      	<c:otherwise>
      		학점은 F 이다.
      	</c:otherwise>
      </c:choose>      
      
    </div>
<%@ include file ="footer.jsp" %>