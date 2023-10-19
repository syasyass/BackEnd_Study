<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file = "../layouts/header.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/@fancyapps/ui@5.0/dist/fancybox/fancybox.umd.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@fancyapps/ui@5.0/dist/fancybox/fancybox.css"/>

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
.thumb-images > a {
	width: 20%;
}

.thumb-images img {
	width: 100%;
	height: 150px;
	padding: 2px;
	object-fit: cover;
}

.image-panel {
	width: 300px;
	height: 270px;
}

.image-panel > img {
	width: 300px;
	height: 200px;
}

.image-panel > .sm-images > img {
	width: 20%;
	height: 60px;
	object-fit: cover;
	cursor: pointer;
}

</style>

<script>
	$(document).ready(function(){
		$('.remove').click(function(){ //post라서 .list, .modify와 달리 별도 처리 필요
				//클릭 이벤트 핸들러 함수
				if(!confirm('정말 삭제할까요?')) return;
				
				//form을 얻어서 submit() 호출
				//console.log(document.forms);
				document.forms.removeForm.submit();
			});
		
		$('.sm-images > img').mouseenter(function(e){
			let src = $(this).attr('src');
			$('.image-panel > img').attr('src', src);
		});
		
		Fancybox.bind('[data-fancybox="gallery"]', {
			// Your custom options
			
		});
	});
	</script>

<h1 class="page-header mt-4">
<i class="far fa-file-alt"></i> ${travel.title}
</h1>
<div class="d-flex justify-content-between">
	<div class="mt-4">
		${travel.region}
	</div>
	<div class="mt-4">
		<span class="heart">
			<i class="${travel.myHeart ? 'fa-solid' : 'fa-regular'} fa-heart text-danger"
				data-tno = "${travel.no}"></i>
			<span class="heart-count">${travel.hearts}</span>
		</span>
		&nbsp&nbsp&nbsp<i class="fa-solid fa-phone"> 연락처: 관광안내소 ${travel.phone}</i>
	</div>
</div>

<hr>

<div class="clearfix mt-4"> <!-- float를 적용시키지 말라는 뜻 -->
	<div class="image-panel float-left mr-3">
		<img src="${travel.image}">
		<div class="sm-images mt-1 d-flex">
			<c:forEach var="image" items="${travel.images}">
			<img src="${image}"></c:forEach>
		</div>
	</div>
	${travel.description}
</div>

<div class="thumb-images my-5 d-flex">
	<c:forEach var="image" items="${travel.images}">
	<a href = "${image}" data-fancybox="gallery">
	<img src="${image}"></a></c:forEach>
</div>

<div>
	<h4>주변 볼거리</h4>
	<c:forEach var="local" items="${travel.locals}">
		<div>
			${local.placeName} / ${local.roadAddressName} / ${local.phone}
		</div>
	</c:forEach>
</div>

<div class="mt-4">
	<i class="fa-solid fa-map-location-dot"></i> 주소: ${travel.address}
</div>

<!-- 카카오맵 자바스크립트 키 97a9015498ead4a6b2a0dd3237525dfb -->
<div id="map" style="width:100%; height:350px; background:gray"></div>
	
<hr>

<div class="mt-4">
	<a href="${cri.getLink('list')}" class="btn btn-primary list">
		<i class="fas fa-list"></i>목록</a>
	<sec:authorize access="hasRole('ROLE_MANAGER')">
	<a href="${cri.getLink('modify')}&no=${travel.no}" class="btn btn-primary modify">
		<i class="fas fa-edit"></i>수정</a>
	<a href="#" class="btn btn-danger remove">
		<i class="fas fa-trash-alt"></i>삭제</a>
	</sec:authorize>
</div>

<form action="remove" method="post" name="removeForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="hidden" name="no" value="${travel.no}" />
	<input type="hidden" name="pageNum" value="${cri.pageNum}" />
	<input type="hidden" name="amount" value="${cri.amount}" />
	<input type="hidden" name="type" value="${cri.type}" />
	<input type="hidden" name="keyword" value="${cri.keyword}" />
</form>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=97a9015498ead4a6b2a0dd3237525dfb&libraries=services"></script>
<script>
  let geocoder = new kakao.maps.services.Geocoder();
  let address = '${travel.address}';
  
  // 비동기 함수 (callback))
  geocoder.addressSearch(address, function(result, status){
	  if(status === kakao.maps.services.Status.OK) {
		  // 배열의 첫번째 위치로 이동
		  let coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		  
		  let mapContainer = document.getElementById('map');  //  지도 생성
		  let mapOption = {//  지도 제어 코딩
				  center: coords, // 중심 좌표
				  level: 3 // 지도의 확대 레벨
		  };
		  
		  let map = new kakao.maps.Map(mapContainer, mapOption);
		  
		  let marker = new kakao.maps.Marker({
			  map: map,
			  position: coords
		  });
		  
		  // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		  map.setCenter(coords);
	  } else {
		  alert("잘못된 주소입니다.");
	  }
  });
 
</script>

<%@ include file="../layouts/footer.jsp" %>