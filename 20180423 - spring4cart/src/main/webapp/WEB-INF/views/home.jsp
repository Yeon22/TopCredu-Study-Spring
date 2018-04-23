<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<title>OracleJava Community Spring4 MVC Cart</title>
</head>
<body>
<h1>
	OracleJava Community Spring4 MVC Cart
</h1>

<c:forEach items="${cart}" var="goods">
	Name : ${goods.name}, Price : ${goods.price}, Cnt : ${goods.cnt}
	<br/>
</c:forEach>
<br/><br/>

<h1>Add Cart...</h1>
<form method="post" action="add">
	Name : <input type="text" name="name"/><br>
	Price : <input type="text" name="price"/><br>
	Cnt : <input type="text" name="cnt"/><br><br>
	<button>Add Goods...</button>
</form>

</body>
</html>
