<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
	width: 360px;
	padding: 8% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4CAF50;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	background: #43A047;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #4CAF50;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 50px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: #EF3B3A;
}
</style>
<script type="text/javascript">
	$(function() {
		$('.message a').click(function() {
			$('form').animate({height : "toggle", opacity : "toggle"}, "slow");
			$('#result').css('display','none');
		});

		var result = "${result}";
		if(result){
			if(result === 'OK'){
				$("#myModal").modal('show');
			} else {
				$('form').animate({height : "toggle", opacity : "toggle"}, "fast");
			}
		}
	});
</script>
</head>
<body>

	<c:import url="nav_top.jsp"></c:import>
	
	<div class="login-page">
		<div class="form">
			<form class="register-form" action="<c:url value='/users/enroll'/>" method="post">
				<input type="text" id="email" name="email" placeholder="Email" /> 
				<input type="password" id="password" name="password" placeholder="Password" /> 
				<button type="submit">create</button>
				<p class="message">Already registered? <a href="#">Sign In</a></p>
			</form>
			<form class="login-form" action="<c:url value='/login'/>" method="post">
				<input type="text" id="email" name="email" placeholder="Email" value="${login.email }"/> 
				<input type="password" id="password" name="password" placeholder="Password" />
				<button type="submit">login</button>
				<p class="message">Not registered? <a href="#">Create an account</a></p>
			</form>
			<c:if test="${not empty error }">
				<br>
				<span class="label label-danger" id="result">${error }</span>
			</c:if>
		</div>
	</div>

	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Completed Membership</h4>
				</div>
				<div class="modal-body">
					<p>Your registration has been successfully completed.</p>
					<p class="text-warning">
						<small>Please click the OK button and try logging in.</small>
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>