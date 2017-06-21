<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/login" method="GET" >
		<input type="submit" value="Login" />
	</form>
	
	<a href="<c:url value="/secure" />"> Admin</a>
	<a href="<c:url value="/userPage" />"> User</a>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Type</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<td>${product.productType}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>