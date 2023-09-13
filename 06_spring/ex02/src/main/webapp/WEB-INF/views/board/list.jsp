<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file = "../layouts/header.jsp" %>

<script>
$(document).ready(function() {
	let actionForm= $('#actionForm');
	
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
		});
});
</script>

<%--개별페이지--%>
<h1 class="page-header">
<i class="fas fa-list"></i> Board List</h1>

<div>
	총 ${pageMaker.total} 건
	(${pageMaker.cri.pageNum} 페이지 / 총 ${pageMaker.totalPage} 페이지)
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
				<td>
					<a class="move" href="${board.bno}">${board.title}</a>
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

<form id="actionForm" action="/board/list" method="get">
	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}" /> <!-- 클릭할 때 a태그 내 내용 변경 -->
	<input type="hidden" name="amount" value="${pageMaker.cri.amount}" />
</form>

<ul class="pagination justify-content-center">
	<c:if test="${pageMaker.cri.pageNum > 1}">
		<li class="page-item">
			<a class="page-link" href="1"> <!-- 1은 페이지 번호 -->
				<i class="fa-soild fa-backward-step"></i>
			</a>
		</li>
	</c:if>
	
	<c:if test="${pageMaker.cri.pageNum > 1}">
		<li class="page-item">
			<a class="page-link" href="${pageMaker.startPage-1}">
				<i class="fa-soild fa-angle-left"></i>
			</a>
		</li>
	</c:if>
	
	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
		<li class="page-item ${ pageMaker.cri.pageNum == num ? 'active' : '' }">
			<a class="page-link" href="${num}">${num}</a>
		</li>	
	</c:forEach>
	
	<c:if test="${pageMaker.next}">
		<li class="page-item">
			<a class="page-link" href="${pageMaker.endPage+1}">
				<i class="fa-soild fa-angle-right"></i>
			</a>
		</li>
	</c:if>
	
	<c:if test="${pageMaker.cri.pageNum < pageMaker.totalPage}">
		<li class="page-item">
			<a class="page-link" href="${pageMaker.totalPage}">
				<i class="fa-soild fa-forward-step"></i>
			</a>
		</li>
	</c:if>
</ul>

<%@ include file = "../layouts/footer.jsp" %>