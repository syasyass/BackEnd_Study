<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../layouts/header.jsp" %>

<sec:authentication property="principal.member" var="member"/>

<sec:authorize access="isAuthenticated()">
<div class="d-flex my-3">
	<form:form modelAttribute="member" enctype="multipart/form-data"
				action="/security/profile?_csrf=${_csrf.token}"
				style="width:500px" class="mx-auto"> <!-- 첨부파일 기능 때문에 액션에 암호화 코드 넣음 -->
	<h1 class="mt-4"><img src="/security/avatar/lg/${member.username}" /> Profile</h1>

			<div class="form-group mt-4">
				사용자 ID: ${member.username}
			</div>
			<div>
				가입일: <fmt:formatDate value="${member.regDate}" pattern="yyyy-MM-dd HH:mm" />		
			</div>

	   		<a href="/security/change_password" class="btn btn-primary btn-block" role="button">
	   			<i class="fa-solid fa-user-plus"></i>비밀번호 변경
	   		</a>

			<div class="form-group">
				<form:label path="email">email: ${member.email}</form:label>
				<form:input path="email" cssClass="form-control"/>
				<form:errors path="email" cssClass="error"/>
			</div>
			
			<input type="file" name="avatar" /> <!-- DB에 넣지 않고 따로 처리 -->

			<div class="text-center">
				<button type="submit" class="btn btn-primary">
					<i class="fas fa-undo"></i>확인</button>	
				<button type="reset" class="btn btn-primary">
					<i class="fas fa-undo"></i>취소</button>	
			</div>
	</form:form>
</div>
</sec:authorize>

<%@ include file="../layouts/footer.jsp" %>