<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../layouts/header.jsp" %>

<!-- summernote -->
<link rel="stylesheet" href="/resources/css/summernote/summernote-lite.min.css">
<script src="/resources/js/summernote/summernote-lite.min.js"></script>
<script src="/resources/js/summernote/lang/summernote-ko-KR.min.js"></script>

<script>
$(document).ready(function() {
	$('#content').summernote({
		height: 300, // 에디터높이
		focus: true, // 에디터로딩후포커스를맞출지여부
		lang: "ko-KR",// 한글설정
	});
	
	$('.get').click(function(){
		document.forms.getForm.submit();
	});
});
// 기본글꼴설정
$('#content').summernote('fontName', 'Arial');
</script>

<%--개별페이지--%>
<h1 class="page-header"><i class="far fa-edit"></i>Board Register</h1>
<div class="panel panel-default">
	<div class="panel-heading">board Register</div>
	<div class="panel-body">
		<form role="form" method="post">
			<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
			<input type="hidden" name="amount" value="${cri.amount}"/>
			<input type="hidden" name="bno" value="${board.bno}">
			
			<div class="form-group">
				<label>Title</label>
				<input name="title" class="form-control" value="${board.title}"> <!-- name은 BoardVO에 있는 멤버변수 이름을 사용 -->	
			</div>
			<div class="form-group">
				<label>Writer</label>
				<input name="writer" class="form-control" value="${board.writer}">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control" id="content" name="content" rows="10">${board.content}</textarea>
			</div>
			
			<button type="submit" class="btn btn-primary">
				<i class="fas fa-check"></i>확인</button>	
			<button type="reset" class="btn btn-primary">
				<i class="fas fa-undo"></i>취소</button>	
			<a href="#" class="btn btn-primary get">
				<i class="fas fa-list"></i>돌아가기</a>
		</form>
		
		<form id="getForm" action="/board/get" method="get">
			<input type="hidden" id="bno" name="bno" value="${board.bno}"/>
			<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
			<input type="hidden" name="amount" value="${cri.amount}"/>
		</form>
	</div>
</div>

<%@ include file="../layouts/footer.jsp" %>