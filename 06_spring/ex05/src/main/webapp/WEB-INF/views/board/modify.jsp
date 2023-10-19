<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="../layouts/header.jsp" %>

<!-- summernote -->
<link rel="stylesheet" href="/resources/css/summernote/summernote-lite.min.css">
<script src="/resources/js/summernote/summernote-lite.min.js"></script>
<script src="/resources/js/summernote/lang/summernote-ko-KR.min.js"></script>

<script src="/resources/js/rest.js"></script>

<script>
$(document).ready(function() {
	$('#content').summernote({
		height: 300, // 에디터높이
		focus: true, // 에디터로딩후포커스를맞출지여부
		lang: "ko-KR",// 한글설정
	});
	
	const attaches = $('[name="files"]');
	const attachList = $('#attach-list');
	
	attaches.change(function(e) {
		let fileList = '';
		for(let file of this.files){
			let fileStr=`
			<div>
				<i class="fa-solid fa-file"></i>
				\${file.name}(\${file.size.formatBytes()})
			</div>`;
			fileList += fileStr;
		}
		attachList.html(fileList);			
	});
	
	$('.remove-attachment').click(async function(e) {
		if(!confirm('파일을 삭제할까요?')) return;
		let no = $(this).data("no");
		
		let url= '/board/remove/attach/' + no +'?_csrf=${_csrf.token}';
		let result = await rest_delete(url);
		if(result == 'OK') {
			$(this).parent().remove();
		} else{
			alert('파일 삭제 실패');
		}
	});
	
/* 	$('.get').click(function(){
		document.forms.getForm.submit();
	}); */
});
// 기본글꼴설정
$('#content').summernote('fontName', 'Arial');
</script>

<%--개별페이지--%>
<h1 class="page-header mt-4"><i class="far fa-edit mt-4"></i>글 수정하기</h1>
<div class="panel panel-default">
	<div class="panel-body">
		<form:form modelAttribute="board" role="form" action="?_csrf=${_csrf.token}"
			enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
			<input type="hidden" name="amount" value="${cri.amount}"/>
			<input type="hidden" name="type" value="${cri.type}"/>
			<input type="hidden" name="keyword" value="${cri.keyword}"/>
			<form:hidden path="bno"/>
			<form:hidden path="writer"/>
			
			<div class = "my-3">
				<label for = "attaches">첨부파일</label>
				<c:forEach var = "file" items="${board.attaches}">
					<div>
						<i class="fa-solid fa-floppy-disk"></i> ${file.filename}
						(${file.formatSize})
						<button type="button" data-no="${file.no}"
						class="btn btn-danger btn-sm py-0 px-1 remove-attachment">
							<i class="fa-solid fa-times"></i>
						</button>
					</div>
				</c:forEach>
			</div>
			
			<div class="form-group">
				<label for="attaches">추가 첨부파일</label>
				<div id="attach-list" class="my-1"></div>
				<input type="file" class="form-control" multiple name="files" />
			</div>
			
			<div class="form-group">
				<form:label path="title">제목</form:label>
				<form:input path="title" cssClass="form-control"/> <!-- name은 VO에 있는 멤버변수 이름을 사용 -->	
				<form:errors path="title" cssClass="error"/>
			</div>
			
			<div class="form-group">
				<form:label path="content">내용</form:label> <!-- id는 summernote 용 --> 
				<form:textarea path="content" cssClass="form-control"></form:textarea>
				<form:errors path="content" cssClass="error"/>
			</div>
			
			<button type="submit" class="btn btn-primary">
				<i class="fas fa-check"></i>확인</button>	
			<button type="reset" class="btn btn-primary">
				<i class="fas fa-undo"></i>취소</button>	
			<a href="${cri.getLinkWithBno('get', board.bno)}" class="btn btn-primary get">
				<i class="fas fa-list"></i>돌아가기</a>
		</form:form>
	</div>
</div>

<%@ include file="../layouts/footer.jsp" %>