<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Add New Emp</title>
</head>
<body>
<h1>
	Add New Emp
</h1>
<form:form action="add.html" method="post" commandName="emp">
	<table>
		<tr>
			<td><form:label path="name">name</form:label></td>
			<td><form:input path="name"/></td>
		</tr>
		
		<tr>
			<td><form:label path="age">Age</form:label></td>
			<td><form:input path="age"/></td>
		</tr>
		
		<tr>
			<td colsapn="2"><input type="submit" value="Add Emp" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>
