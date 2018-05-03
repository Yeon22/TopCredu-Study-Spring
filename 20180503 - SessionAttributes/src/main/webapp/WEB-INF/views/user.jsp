<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BORAJI.COM</title>
</head>
<body>
	<h1>User profile Page</h1>
	<table>
		<tr>
			<td>First Name</td>
			<td>${user.fname}</td>
		</tr>
		<tr>
			<td>Middle Name</td>
			<td>${user.mname}</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${user.lname}</td>
		</tr>
		<tr>
			<td>Age</td>
			<td>${user.age}</td>
		</tr>
	</table>
</body>
</html>