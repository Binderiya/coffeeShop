<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>You are in!</title>
</head>
<body>
	<h1>You made it!</h1>
	<a href="<c:url value="/logout" />"> Now logout </a>
	
	<form action="/productList" method="GET">
		<input type="submit" value="Product list" />
	</form>
	<form action="/orderList" method="GET">
		<input type="submit" value="Order list" />
	</form>
		<form action="/personList" method="GET">
		<input type="submit" value="Person list" />
	</form>
</body>
</html>