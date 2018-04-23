<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Multiple File Upload</title>
</head>
<body>
	<p>upload ok!!</p>
	<ol>
		<!-- 아래 files는 컨트롤러에서 직접 넘겨준 모델명 -->
		<c:forEach var="file" items="${files}">
			<li>${files}</li>
		</c:forEach>
		<!-- 컴트롤러에서 @ModelAttribute로 선언된 객체는 자동으로 view로 전달 -->
		<br><br>Upload Path : ${uploadForm.upDir}
	</ol>
</body>
</html>