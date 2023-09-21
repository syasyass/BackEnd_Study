<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file = "../layouts/header.jsp" %>

<h1 class="page-header">
<i class="fas fa-list"></i> Board List</h1>

<%@ include file="../common/search_bar.jsp" %>

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