<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Board</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.bs-example {
	margin: 20px;
}
.logo-small {
    color: #f4511e;
    font-size: 50px;
}
footer .glyphicon {
    font-size: 20px;
    margin-bottom: 20px;
    color: #f4511e;
}
</style>
</head>
<body id="myPage">
	<c:import url="nav_top.jsp"></c:import>
	
	<br>
	<br>
	<br>
	
	<div id="services" class="container-fluid text-center">
		<h2>BOARD DEMO</h2>
		<h4>Spring Boot + MyBatis</h4>
		<br>
		<div class="row slideanim">
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-off logo-small"></span>
				<h4>
					<c:if test="${not empty user }">
						<a href="logout">LOGOUT</a>
					</c:if>
					<c:if test="${empty user }">
						<a href="login">LOGIN</a>
					</c:if>
				</h4>
				<p>Lorem ipsum dolor sit amet..</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-heart logo-small"></span>
				<h4><a href="boards">BOARD</a></h4>
				<p>Lorem ipsum dolor sit amet..</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-lock logo-small"></span>
				<h4>YOUR TURN</h4>
				<p>Lorem ipsum dolor sit amet..</p>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	
	<footer class="container-fluid text-center">
		<a href="#myPage" title="To Top"><span class="glyphicon glyphicon-chevron-up"></span></a>
		<p>Made By <a href="#" title="#">have a nice day!</a></p>
	</footer>
</body>
</html>