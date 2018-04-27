<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AOP Table</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
.bs-example{
	margin: 20px;
}

.pagination{
	margin: 0px !important;
}

th, td{
	text-align: center;
}
</style>
</head>
<body>
	<h2 style="text-align: center;">AOP Table</h2>
	<table class="table table-condensed table-hover table-striped">
		<thead>
			<tr>
				<th class="col-xs-2 col-sm-2 col-md-2 col-lg-2">개발자</th>
				<th class="col-xs-2 col-sm-2 col-md-2 col-lg-2">포인트컷</th>
				<th class="col-xs-2 col-sm-2 col-md-2 col-lg-2">소요시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${aopResult}" var="aop">
				<tr>
					<td>${aop.name}</td>
					<td>${aop.pointcut}</td>
					<td>${aop.elapsedtime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>