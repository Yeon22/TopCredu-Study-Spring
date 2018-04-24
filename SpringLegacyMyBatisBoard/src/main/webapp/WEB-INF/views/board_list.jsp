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
	margin: 20px;
}
.pagination {
	margin: 0px !important;
}
</style>
</head>
<body>
	<c:import url="nav_top.jsp"></c:import>

	<div class="bs-example">
		<h2>Board</h2>
		<table class="table table-condensed table-hover table-striped">
			<thead>
				<tr>
					<th class="col-xs-1 col-sm-1 col-md-1 col-lg-1">No</th>
					<th class="col-xs-6 col-sm-6 col-md-6 col-lg-6">Title</th>
					<th class="col-xs-2 col-sm-2 col-md-2 col-lg-2">Writer</th>
					<th class="col-xs-2 col-sm-2 col-md-2 col-lg-2">Date</th>
					<th class="col-xs-1 col-sm-1 col-md-1 col-lg-1">Hits</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="#{boards }" var="board">
					<tr>
						<td>${board.id }</td>
						<td><a href="<c:url value='/boards/view/${board.id }'/>">${board.title }</a></td>
						<td>${board.writer }</td>
						<td><fmt:formatDate pattern="MM-dd hh:mm" value="${board.regDate }" /></td>
						<td>${board.hitCount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
			<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
				<ul class="pagination">
					<c:set var="target" value="boards" />
					<c:if test="${pager.rows==0 }">
						<li class="active"><a href="#">1</a></li>
					</c:if>
					<c:if test="${pager.rows > 0 }">
						<c:set var="common" value="size=${pager.size }&bsize=${pager.bsize }" />
						<c:if test="${pager.bspage > pager.bsize }">
							<c:set var="home" value="page=1&${common }" />
							<c:set var="prev" value="page=${pager.bspage-1 }&${common }" />
							<li><a href="${target }?${home }">Home</a></li>
							<li><a href='<c:url value="${target }?${prev }"/>'>&laquo;</a></li>
						</c:if>
						<c:forEach var="pno" begin="${pager.bspage }" end="${pager.bepage }">
							<c:if test="${pno==pager.page }">
								<li class="active"><a href="#">${pno }</a></li>
							</c:if>
							<c:if test="${pno!=pager.page }">
								<c:if test="${pno <= pager.pages }">
									<c:set var="page" value="page=${pno }&${common }" />
									<li><a href='<c:url value="${target }?${page }"/>'>${pno }</a></li>
								</c:if>
							</c:if>
						</c:forEach>
						<c:if test="${pager.bepage < pager.pages }">
							<c:set var="next" value="page=${pager.bepage+1 }&${common }" />
							<c:set var="last" value="page=${pager.pages }&${common }" />
							<li><a href='<c:url value="${target }?${next }"/>'>&raquo;</a></li>
							<li><a href="${target }?${last }">Last</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
			<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
				<span class="pull-right"> <a href="<c:url value='/boards/write'/>" class="btn btn-primary">Write</a>
				</span>
			</div>
		</div>
	</div>
</body>
</html>