<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../layouts/header.jsp" %>
<%@ include file="../common/search_bar.jsp" %>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

<style>
.card-img-top {
	height: 200px;
	object-fit: cover;
}

.card-text {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>

<%-- <table class="table table-striped table-hover">
	<thead>
		<tr>
			<th style="width: 60px">No</th>
			<th style="width: 100px">권역</th>
			<th>제목</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="travel" items="${list}">
			<tr>
				<td>${travel.no}</td>
				<td>${travel.region}</td>
				<td><a href="${cri.getLink('get')}&no=${travel.no}"> <!-- pk인 no는 직접 삽입 -->
					${travel.title}</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table> --%>

<div class="row">
	<c:forEach var="travel" items="${list}">
		<div class="col-sm-6 col-md-4 mb-3">
			<div class="card" style="width:100%">
				<a href="${cri.getLink('get')}&no=${travel.no}">
					<img class="card-img-top" src="${travel.image}" alt="${travel.title}">
				</a>
				<div calss="card-body">
					<h4 class="card-title">
						<a href="${cri.getLink('get')}&no=${travel.no}">
							${travel.title}
						</a>
					</h4>
					<a href="#" class="heart">
						<i class="fa-regular fa-heart text-danger"></i>
					</a>
					${travel.hearts}
					<p class="card-text">${travel.summary}</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<sec:authorize access="hasRole('ROLE_MANAGER')">
	<div class="text-right">
		<a href="register" class="btn btn-primary">
		<i class="far fa-edit"></i>
		추가
		</a>
	</div>
</sec:authorize>

<%@ include file="../common/pagination.jsp" %>

<%@ include file="../layouts/footer.jsp" %>