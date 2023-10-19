<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file = "../layouts/header.jsp" %>

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
					<a href="get?bno=${board.bno}">${board.title}</a>
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

<%@ include file = "../layouts/footer.jsp" %>