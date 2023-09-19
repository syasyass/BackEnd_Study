<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username"/>  
	</sec:authorize>
</h1>
<sec:authorize access="isAnonymous()">
	<a href="/security/login">로그인</a>
</sec:authorize>
<br>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.username"/> 
	<br>
	<form action="/security/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}"/>
		<input type="submit" value="로그아웃"/>
	</form>
</sec:authorize>

</body>
</html>
