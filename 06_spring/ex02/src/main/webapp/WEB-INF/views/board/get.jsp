<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file = "../layouts/header.jsp" %>

<script>
		
	$(document).ready(function(){
			$('.remove').click(function(){
				//클릭 이벤트 핸들러 함수
				//if(!confirm('정말 삭제할까요?')) return;
				
				//form을 얻어서 submit() 호출
				//console.log(document.forms);
				document.forms.removeForm.submit();
			});
		});
	</script>

<%--개별페이지--%>
<h1 class="page-header"><i class="far fa-file-alt"></i>${board.title}</h1>
<div class="d-flex justify-content-between">
	<div><i class="fas fa-user"></i>${board.writer}</div>
	<div>
		<i class="fas fa-clock"></i>
		<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}" />
	</div>
</div>

<hr>

<div>
	${board.content}
</div>

<div class="mt-4">
	<a href="list" class="btn btn-primary">
		<i class="fas fa-list"></i>목록</a>
	<a href="modify?bno=${board.bno}" class="btn btn-primary">
		<i class="fas fa-edit"></i>수정</a>
	<a href="#" class="btn btn-danger remove">
		<i class="fas fa-trash-alt"></i>삭제</a>
</div>

<form action="remove" method="post" name="removeForm">
	<input type="hidden" name="bno" value="${board.bno}" />
</form>

<%@ include file="../layouts/footer.jsp" %>