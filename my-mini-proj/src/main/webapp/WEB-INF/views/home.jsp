<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<sec:authorize access="isAnonymous()">
		<a href="/security/login">login</a>
	</sec:authorize>
	
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.username"/>
		<form action="/security/logout" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value="logout"/>
		</form>
</sec:authorize>
</body>
</html>
