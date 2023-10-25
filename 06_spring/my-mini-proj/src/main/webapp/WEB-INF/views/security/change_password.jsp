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
				action="/security/change_password?_csrf=${_csrf.token}"
				style="width:500px" class="mx-auto"> <!-- 첨부파일 기능 때문에 액션에 암호화 코드 넣음 -->
	<h1 class="mt-4"><img src="/security/avatar/lg/${member.username}" /> Change Password</h1>

			<div class="form-group mt-4">
				사용자 ID: ${member.username}
			</div>
			
			<div class="form-group mt-4">
				<form:label path="orgPassword">이전 비밀번호 입력</form:label>
				<form:input path="orgPassword" cssClass="form-control"/>
				<form:errors path="orgPassword" cssClass="error"/>
			</div>

			<div class="form-group mt-4">
				<form:label path="newPassword">새 비밀번호 입력</form:label>
				<form:input path="newPassword" cssClass="form-control"/>
				<form:errors path="newPassword" cssClass="error"/>
			</div>
			<div class="form-group">
				<form:label path="newPassword2">새 비밀번호 확인</form:label>
				<form:input path="newPassword2" cssClass="form-control"/>
				<form:errors path="newPassword2" cssClass="error"/>
			</div>
			
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