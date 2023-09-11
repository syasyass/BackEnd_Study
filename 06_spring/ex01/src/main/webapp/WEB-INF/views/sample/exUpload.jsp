<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<form
		action="/sample/exUploadPost"
		method="post"
		enctype="multipart/form-data">
	
		<div>
			<input type="file" name="files" multiple="multiple"/> <!-- 업로드 할 때 다중 선택 가능 -->
		</div>
		<div>
			<input type="file" name="files" />
		</div>
		<div>
			<input type="file" name="files" />
		</div>
		<div>
			<input type="file" name="files" />
		</div>
		<div>
			<input type="file" name="files" />
		</div>
		<div>
			<input type="submit" />
		</div>		
	</form>
</body>
</html>