<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file = "../layouts/header.jsp" %>

<script>
$(document).ready(function() {
	// Criteria 값을 넘겨주는 getLink() (UriComponentsBuilder)를 사용하게 되면서 필요 없어짐
/* 	let actionForm= $('#actionForm');
		$('a.page-link').on('click', function(e) {
			e.preventDefault();		// 해당 태그의 디폴트 액션 실행을 막음
			console.log('click');
			actionForm.find('input[name="pageNum"]')	//<input name="pageNum" ....>을 찾음
			.val($(this).attr('href'));		//input 내 <a href="1"> 등을 찾아 val값을 삽입
											// attr(속성명) => read / attr(속성명, 값) => write
											// this는 $('#actionForm')의 jQuery 모두를 가리킴
			actionForm.submit();
	});

		$('.move').on('click', function(e) {
			e.preventDefault();
			actionForm.append('<input type="hidden" name="bno"/>');
			actionForm.find('input[name="bno"]')
			.val($(this).attr('href'));
			actionForm.attr('action', '/board/get');
			actionForm.submit();
		}); */
	
	// required. 필수 요소 체크 코드
	let searchForm= $('#searchForm'); // 자손
		$('#searchForm button').on('click', function(e) { // 후손. 검색 버튼
			let type = searchForm.find('option:selected'); // : 은 상태 선택자
			if(!type.val()){
				alert('검색 종류를 선택하세요.');
				type.focus();
				return false; //submit 하지 말라는 뜻
			}
		
			let keyword = searchForm.find('input[name="keyword"]');
			if(!keyword.val()){
				alert('키워드를 입력하세요.');
				keyword.focus();
				return false;
			}
			
			searchForm.find('input[name="pageNum"]').val('1');
			e.preventDefault();
			
			searchForm.submit();
		
		});		
});
</script>

<%--개별페이지--%>
<h1 class="page-header">
<i class="fas fa-list"></i> Board List</h1>

<%-- <div>
	총 ${pageMaker.total} 건
	(${pageMaker.cri.pageNum} 페이지 / 총 ${pageMaker.totalPage} 페이지)
</div> --%>

<!-- d-flex를 쓰면 안쪽 코드들이 inline-block으로 바뀜. 폭에 의한 콘텐츠 크기를 재기 때문에 한 줄로. -->
<div class="d-flex justify-content-between align-items-center my-4">
	<div class=" ">
		총 ${pageMaker.total} 건
		( ${pageMaker.cri.pageNum} ... ${pageMaker.totalPage})
	</div>
	<div>
		<form id="searchForm" method="get" class="d-flex" >
			<input type = "hidden" name="pageNum" value="1">
			<select name="type" class="form-select rounded-0 ml-1">
				<option value="" ${pageMaker.cri.type == null ? 'selected' : ''}>
					-- 검색대상선택 --</option>
				<option value="T" ${pageMaker.cri.type eq 'T' ? 'selected' : ''}>
					제목</option>
				<option value="C" ${pageMaker.cri.type eq 'C' ? 'selected' : ''}>
					내용</option>
				<option value="W" ${pageMaker.cri.type eq 'W' ? 'selected' : ''}>
					작성자</option>
				<option value="TC" ${pageMaker.cri.type eq 'TC' ? 'selected' : ''}>
					제목+내용</option>
				<option value="TW" ${pageMaker.cri.type eq 'TW' ? 'selected' : ''}>
					제목+작성자</option>
				<option value="TWC" ${pageMaker.cri.type eq 'TWC' ? 'selected' : ''}>
					제목+내용+작성자</option>
			</select>
			<div class="input-group">
				<input type="text" name="keyword" class="form-control rounded-0"
					value="${pageMaker.cri.keyword}" />
				<button type="submit" class="btn btn-success rounded-0">
					<i class="fa-solid fa-magnifying-glass"></i> 검색</button>
			</div>
		</form>
	</div>
</div>

<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="board" items="${list}">
			<tr>
				<td style="width:60px">${board.bno}</td>
				<td><a class="move" href="${cri.getLinkWithBno('get', board.bno)}">
					${board.title}</a>
				</td>
				<td style="width:100px">${board.writer}</td>
				<td style="width:130px">
					<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<div class="text-right">
	<a href="register" class="btn btn-primary">
	<i class="far fa-edit"></i>
	글쓰기
	</a>
</div>

<%@ include file="../common/pagination.jsp" %>

<!-- Criteria 값을 넘겨주는 getLink() (UriComponentsBuilder)를 사용하게 되면서 필요 없어짐 -->
<!-- <form id="actionForm" action="/board/list" method="get">
	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}" /> <!-- 클릭할 때 a태그 내 내용 변경 -->
<!-- <input type="hidden" name="amount" value="${pageMaker.cri.amount}" />
	<input type="hidden" name="type" value="${pageMaker.cri.type}" />
	<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}" />
</form> -->

<%@ include file = "../layouts/footer.jsp" %>