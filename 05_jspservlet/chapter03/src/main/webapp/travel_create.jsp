<!-- jsp 시작시 필요한 부분 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <!-- CDN: Content Delivery Network -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
      integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <!-- Latest compiled and minified CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
    />

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="/css/main.css" />
    <style></style>
  </head>
  <body>
    <div class="container">
      <h1><i class="fa-solid fa-plane"></i>관광지 등록</h1>
      <form action = "travel_add" method="post" class="form mt-5">
      	<div class="form-group">
      		<label>권역</label>
      		<select name="region" class="form-control" style="width:200px">
      			<option value="수도권">수도권</option>
      			<option value="강원권">강원권</option>
      			<option value="경상권">경상권</option>
      			<option value="충청권">충청권</option>
      			<option value="전라권">전라권</option>
      			<option value="제주권">제주권</option>
      		</select>
      	</div>
      	
      	<div class="form-group">
      		<label>관광지명</label>
      		<input type="text" name="title" class="form-control">
      	</div>
      	
      	<div class="form-group">
      		<label>주소</label>
      		<input type="text" name="address" class="form-control">
      	</div>
      	
      	<div class="form-group">
      		<label>전화번호</label>
      		<input type="text" name="phone" class="form-control">
      	</div>
      	
      	<div class="form-group">
      		<label>내용</label>
      		<textarea name="description" rows="8" class="form-control"></textarea>
      	</div>
      	
      	<div>
      		<button type="submit" class="btn btn-primary">
      		<i class="fa-solid fa-check"></i>확인</button>
      		<button type="reset" class="btn btn-primary">
      		<i class="fa-solid fa-xmark"></i>취소</button>
      	</div>	
      
      </form>      
    </div>
  </body>
</html>
