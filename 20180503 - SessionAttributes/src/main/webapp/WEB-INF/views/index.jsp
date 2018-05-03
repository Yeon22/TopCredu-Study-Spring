<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>BORAJI.COM</title>
</head>
<body>
<h1>
	User Login
</h1>
<form:form action="dologin" method="post" modelAttribute="user">
	<table>
		<tr>
			<td>Email</td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password"/></td>
		</tr>
		<tr>
			<td><button type="submit">Login</button></td>
		</tr>
	</table>
</form:form>
<span style="color: red;">${message}</span>
</body>
</html>
