<!-- jsp 시작시 필요한 부분 -->
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="header.jsp" %>
<%
	Date d = new Date();
%>
  <body>
    <div class="container">
      <h1>
      	Glory에 오신것을 환영합니다. 현재 시간: <%=d.toLocaleString()%>
      </h1> 
      <a href="about.jsp">about</a>
      <h1>
      	로그인 입력 화면
      </h1>
      <form action="loginInfo.jsp" method="post">
      	<fieldset>
      		<legend>로그인 폼</legend>
      		<ul>
      			<li>
      				<label for="userid">아이디</label>
      				<input type="text" name="userid">
      			</li>
      			<li>
      				<label for="Password">비밀번호</label>
      				<input type="text" name="Password">
      			</li>
      			<li><input type="submit" value="전송"></li>
      		</ul>
      	</fieldset>
      </form>
    </div>
  </body>
<%@ include file ="footer.jsp" %>