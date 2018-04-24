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
		<form class="form-horizontal" action="/examples/actions/confirmation.php" method="post">
			<div class="form-group">
				<label for="title" class="control-label col-xs-2">Title</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" id="title" name="title" placeholder="Title" required
						value="${board.title }" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label for="writer" class="control-label col-xs-2">Writer</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" id="writer" name="writer" placeholder="Writer" required
						value="${board.writer }" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label for="content" class="control-label col-xs-2">Content</label>
				<div class="col-xs-10">
					<textarea class="form-control" rows="20" id="content" name="content" placeholder="Content" required
						readonly="readonly">${board.content }</textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="regDate" class="control-label col-xs-2">Date</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" id="regDate" name="regDate" placeholder="Date" required
						value="<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${board.regDate }" />" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-offset-2 col-xs-10">
					<a href="<c:url value='/boards'/>" class="btn btn-primary">List</a>
					<c:if test="${not empty user }">
						<c:if test="${user.email == board.writer }">
							<a href="<c:url value='/boards/delete/${board.id }'/>" class="btn btn-primary">Delete</a>
							<a href="<c:url value='/boards/update/${board.id }'/>" class="btn btn-primary">Update</a>
						</c:if>
					</c:if>
				</div>
			</div>
		</form>
	</div>
</body>
</html>