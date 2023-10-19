<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1>페이지타이틀</h1>
<div>
	<h4><c:out value="${exception.getMessage()}"></c:out></h4>
	
	<ul>
		<c:forEach items="${exception.getStackTrace()}" var="stack">
			<li><c:out value="${stack}"></c:out></li>
		</c:forEach>
	</ul>

</div>