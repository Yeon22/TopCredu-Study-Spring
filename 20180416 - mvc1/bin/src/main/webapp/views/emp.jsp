<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h3>EMP 테이블 목록</h3>
	<h5>총 ${emps.size()}건</h5>
	<table border="1">
		<tr align="left">
			<th width="100" align="center">사번</th>
			<th width="200" align="center">이름</th>
			<th width="100" align="center">급여</th>
		</tr>
		<c:forEach var="emp" items="${emps}">
		<tr>
			<td align="center">${emp.empno}</td>
			<td align="center">${emp.ename}</td>
			<td align="center">${emp.sal}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
