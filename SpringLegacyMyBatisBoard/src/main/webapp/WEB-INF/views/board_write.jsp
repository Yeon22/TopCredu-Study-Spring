<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.bs-example {
	margin-bottom: 20px;
	margin-left: 20px;
	margin-right: 40px;
	margin-top: 20px;
}
</style>
</head>
<body>
	<c:import url="nav_top.jsp"></c:import>
	
	<div class="bs-example">
		<form class="form-horizontal" action="<c:url value='/boards/write'/>" method="post">
			<div class="form-group">
				<label for="title" class="control-label col-xs-2">Title</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" id="title" name="title" placeholder="Title" required>
				</div>
			</div>
			<div class="form-group">
				<label for="writer" class="control-label col-xs-2">Writer</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" id="writer" name="writer" placeholder="Writer" required
						value="${user.email }" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label for="content" class="control-label col-xs-2">Content</label>
				<div class="col-xs-10">
					<textarea class="form-control" rows="20" id="content" name="content" placeholder="Content" required></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-offset-2 col-xs-10">
					<a href="<c:url value='/boards'/>" class="btn btn-primary">List</a>
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>