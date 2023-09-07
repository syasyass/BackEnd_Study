<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/user/join" method="POST"> <!-- Get,Post URL이 동일할 때는 action="/user/join"를 생략 가능 -->
		회원 ID: <input type="text" name="userid" value="hong"><br>
		비밀번호: <input type="password" name="password" value="1234"><br>
		비밀번호2: <input type="password" name="password2" value="1234"><br>
		email: <input type="email" name="email" value="hong@naver.com"><br>
		취미: 
			<input type="checkbox" name="hobbies" value="축구" checked> 축구<br>
			<input type="checkbox" name="hobbies" value="농구"> 농구<br>
			<input type="checkbox" name="hobbies" value="배구" checked> 배구<br>
		<br>
		생일: <input type="text" name="birthDate" placeholder="yyyy-MM-dd" value="2000-10-10"> 
		<input type="submit">
	</form>
</body>
</html>