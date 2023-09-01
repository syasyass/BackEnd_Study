<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<c:set var="userid" value="admin" scope="session"/>

    <div class="container">
      <h1>
      	로그인 성공
      </h1> 
      <a href="visit.jsp">Visit</a>
    </div>
<%@ include file ="footer.jsp" %>