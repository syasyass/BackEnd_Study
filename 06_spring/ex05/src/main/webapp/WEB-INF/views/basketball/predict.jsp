<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../layouts/header.jsp" %>

<div class="panel-body">
	<form:form modelAttribute="basketballVO" role="form"> <!-- @ModelAttribute를 안 줬을 때, camel case로 타입명 적어주면 속성명을 뜻하게 됨 -->
		<input type="hidden" name="_csrf" value="${_csrf.token}"/>
		<div class="form-group mt-4">
			<form:label path="P3">P3</form:label>
			<form:input path="P3" cssClass="form-control"/>
		</div>
		
		<div class="form-group mt-4">
			<form:label path="P2">P2</form:label>
			<form:input path="P2" cssClass="form-control"/>
		</div>
		
		<div class="form-group mt-4">
			<form:label path="TRB">TRB</form:label>
			<form:input path="TRB" cssClass="form-control"/>
		</div>
		
		<div class="form-group mt-4">
			<form:label path="AST">AST</form:label>
			<form:input path="AST" cssClass="form-control"/>
		</div>
		
		<div class="form-group mt-4">
			<form:label path="STL">STL</form:label>
			<form:input path="STL" cssClass="form-control"/>
		</div>
		
		<div class="form-group mt-4">
			<form:label path="BLK">BLK</form:label>
			<form:input path="BLK" cssClass="form-control"/>
		</div>
		
		<div class="form-group mt-4">
			<label>결과</label>
			<div>${result}</div>
		</div>
		
		<button type="submit" class="btn btn-primary">
					<i class="fas fa-undo"></i>확인</button>	
				<button type="reset" class="btn btn-primary">
					<i class="fas fa-undo"></i>취소</button>	
		
	</form:form>
</div>

<%@ include file="../layouts/footer.jsp" %>