<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../layouts/header.jsp" %>
<%@ include file="../common/search_bar.jsp" %>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<c:if test="${not empty username}">
<style>
.fa-heart {
	cursor: pointer;
}
</style>
<script src ="/resources/js/rest.js"><</script>
<script>
	$(document).ready(function() {
		let username = '${username}';
		
		const BASE_URL = '/api/travel/heart';
		
		//좋아요 추가
		$('span.heart').on('click', '.fa-heart.fa-regular', async function(e){
			let tno = parseInt($(this).data("tno"));
			let heart = { tno, username }; // HeartVO 맵핑
			console.log(heart);
			
			await rest_create(BASE_URL + "/add", heart);
			
			let heartCount = $(this).parent().find(".heart-count"); // parent는 span 태그
			console.log(heartCount);
			let count = parseInt(heartCount.text());
			heartCount.text(count+1);
			
			$(this) // 아이콘 교체
				.removeClass('fa-regular')
				.addClass('fa-solid');
		});
		
		
		//좋아요 제거
		$('span.heart').on('click', '.fa-heart.fa-solid', async function(e){
			let tno = parseInt($(this).data("tno"));
			
			// \$는 EL이 아니라는 뜻. JSP가 먼저 서버에서 본 후, 브라우저에서 JS가 보기 때문에, 표시를 해 줌.
			await rest_delete(`\${BASE_URL}/delete?tno=\${tno}&username=\${username}`);
			
			let heartCount = $(this).parent().find(".heart-count"); // parent는 span 태그
			console.log(heartCount);
			let count = parseInt(heartCount.text());
			heartCount.text(count-1);
			
			$(this) // 아이콘 교체
				.removeClass('fa-solid')
				.addClass('fa-regular');
		});
	});
</script>
</c:if>

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
					<span class="heart">
							<i class="${travel.myHeart ? 'fa-solid' : 'fa-regular'} fa-heart text-danger"
							data-tno = "${travel.no}"></i>
						<span class="heart-count">${travel.hearts}</span>
					</span>
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