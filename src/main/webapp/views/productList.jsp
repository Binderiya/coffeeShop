<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<c:url value="/secure" />"> Login</a>
	<form action="/addProduct" method="GET">
		<input type="submit" value="AddProduct" />
	</form>
	<table>
		<tr>
			<th>ID</th>
			<th>name</th>
			<th>description</th>
			<th>price</th>
			<th>type</th>
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