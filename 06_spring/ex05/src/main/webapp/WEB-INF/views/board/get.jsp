<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"> // moment 날짜 포맷팅
</script>
<script src="/resources/js/rest.js"></script>
<script src="/resources/js/comment.js"></script>
<script src="/resources/js/reply.js"></script>

<%@ include file = "../layouts/header.jsp" %>

<script>
const COMMENT_URL = '/api/board/${param.bno}/comment/';
const REPLY_URL = '/api/board/${param.bno}/reply/';

	$(document).ready(async function(){		// fetch()를 사용하는 함수에 async 작성. 비동기 함수임을 선언
		$('.remove').click(function(){ //post라서 .list, .modify와 달리 별도 처리 필요
				if(!confirm('정말 삭제할까요?')) return;
				
				//form을 얻어서 submit() 호출
				//console.log(document.forms);
				document.forms.removeForm.submit();
			});
	
		let bno = ${param.bno}; 	// 글번호
		let writer = '${username}';	// 작성자(로그인 유저)
		
		loadComments(bno, writer);	// 댓글 목록 불러오기
		
		// 댓글 추가 버튼 처리
		$('.comment-add-btn').click(function(e) {
			createComment(bno, writer);
		});
		
		$('.comment-list').on('click', '.comment-update-show-btn', showUpdateComment);
		
		console.log($('.comment-update-show-btn'));
		
		//수정 확인 버튼 클릭
		$('.comment-list').on('click', '.comment-update-btn', function(e) {
			const el = $(this).closest('.comment');
			
			updateComment(el, writer);
		});
		
		
		//수정 취소 버튼 클릭
		$('.comment-list').on('click', '.comment-update-cancel-btn', cancelCommentUpdate);
		
		//삭제 버튼 클릭
		$('.comment-list').on('click', '.comment-delete-btn', deleteComment);
		
		//// 답글 버튼 이벤트 핸들링
		// 답글 추가 인터페이스 보이기
		$('.comment-list').on('click', '.reply-add-show-btn', function(e) {
			showReplyAdd($(this), writer);			
		});	
		
		// 답글 등록
		$('.comment-list').on('click', '.reply-add-btn', function(e) {
			addReply($(this), writer);			
		});	
		
		// 답글 취소
		$('.comment-list').on('click', '.reply-add-cancel-btn', cancelReply);	
		
		// 답글 수정 화면 보여주기
		$('.comment-list').on('click', '.reply-update-show-btn', function(e) {
			showUpdateReply($(this));			
		});	
		
		// 답글 수정 등록
		$('.comment-list').on('click', '.reply-update', function(e) {
			updateReply($(this));			
		});	
		
		//답글 수정 취소
		$('.comment-list').on('click', '.reply-update-cancel', cancelReplyUpdate);
		
		//답글 삭제
		$('.comment-list').on('click', '.reply-delete-btn', deleteReply);
	}); 
	
	// 이벤트 대상 확인하기 좋은 console 메시지
/* 		$('.comment-list').click(function(e) {
		console.log(e.target)
		}); */
		
	//철기
	//bno 하드코딩 변수 처리
/* 	const bno = ${board.bno};
	
	const url = '/api/board/' + bno +'/comment';
	console.log(url); */
	
	// 생성
/* 	let comment = {
		// bno : // key 이름과 값의 변수명이 동일할 경우, Javascript가 알아서 동일하게 등록해 줌 
			bno,
		writer : '${username}',
		content: "추가 글입니다."			
	};
	console.log(comment);
	console.log(JSON.stringify(comment));
	
	comment = await rest_create(url, comment);
	console.log(comment); */
	
	// 수정
/* 	let comment = {
		no : 9,
		content : "수정한 글입니다."
	};
	
	comment = await rest_modify(url + "/9", comment);
	console.log(comment); */
	
	// 삭제
/* 	let result = await rest_delete(url + "/9");
	console.log(result); */
	
	
	// 목록 추출
/* 	let data = await rest_get(url);
	console.log(data);
	
	}); */
	
	
    //청동기
    /*const url = '/api/board/36/comment/1';
    let data = await rest_get(url);
    console.log(data); */
    
    
    //신석기
 /*     let res = await fetch('/api/board/36/comment');  //GET 요청
    let data = await res.json());
    console.log(data); */
    
    //구석기
    // res=>console.log(res) 와 같음
 /* fetch('/api/board/36/comment') //경로만 가져오기, 두 번째 매개변수 없으니 GET요청
        .then((res) {//익명함수 function, 리턴값의 메서드 then을 호출 -> response 객체
            console.log('응답 수신');
            return res.json(); //Json 문자열을 실제 객체(promise)로 바꿔라 "역직렬화"
        }) //callback 1개 등록
        .then(function(data) {
            console.log('Json 데이터 변환완료');
            console.log(data); //data라는 댓글 배열
        });
        console.log('fetch 호출 완료');
        });
        // res=>console.log(res) 와 같음 */     
</script>

<h1 class="page-header mt-4"><i class="far fa-file-alt"></i>${board.title}</h1>
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

<!-- 새 댓글 작성 / 작성자가 아닌 경우에만 보여주기 -->
<c:if test="${username != board.writer}">
	<div class="bg-light p-2 rounded my-5">
		<div>${username == null ? '댓글을 작성하려면 먼저 로그인하세요' : '댓글작성' }
		</div>
			<div>
				<textarea class="form-control new-comment-content" rows="3"
					${username == null ? 'disabled' : '' }></textarea>
					<div class="text-right">
						<button class="btn btn-primary btn-smmy-2 comment-add-btn"
							${username == null ? 'disabled' : '' } >
							<i class="fa-regular fa-comment"></i> 확인
						</button>
					</div>
			</div>
	</div>
</c:if>

<br>
<i class="fa-regular fa-comments"></i> 댓글 목록
<hr>
<div class="comment-list"></div>

<div class="mt-4">
	<a href="${cri.getLink('list')}" class="btn btn-primary list">
		<i class="fas fa-list"></i>목록</a>
	<c:if test="${username == board.writer}">
	<a href="${cri.getLinkWithBno('modify', board.bno)}" class="btn btn-primary modify">
		<i class="fas fa-edit"></i>수정</a>
	<a href="#" class="btn btn-danger remove">
		<i class="fas fa-trash-alt"></i>삭제</a>
	</c:if>
</div>

<form action="remove" method="post" name="removeForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="hidden" name="bno" value="${board.bno}" />
	<input type="hidden" name="pageNum" value="${cri.pageNum}" />
	<input type="hidden" name="amount" value="${cri.amount}" />
	<input type="hidden" name="type" value="${cri.type}" />
	<input type="hidden" name="keyword" value="${cri.keyword}" />
</form>

<%@ include file="../layouts/footer.jsp" %>