<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../layouts/header.jsp" %>

<%--개별페이지--%>
<h1 class="page-header"><i class="far fa-edit"></i>Board Register</h1>
<div class="panel panel-default">
	<div class="panel-heading">board Register</div>
	<div class="panel-body">
		<form role="form" method="post">
			<div class="form-group">
				<label>Title</label>
				<input name="title" class="form-control">			
			</div>
			<div class="form-group">
				<label>Writer</label>
				<input name="writer" class="form-control">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control" name="content" rows="10"></textarea>
			</div>
			
			<button type="submit" class="btn btn-primary">
				<i class="fas fa-undo"></i>확인</button>	
			<button type="submit" class="btn btn-primary">
				<i class="fas fa-undo"></i>취소</button>	
			<a href="list" class="btn btn-primary">
				<i class="fas fa-list"></i>목록</a>
		</form>
	</div>
</div>

<%@ include file="../layouts/footer.jsp" %>