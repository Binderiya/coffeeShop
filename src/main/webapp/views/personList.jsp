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
	<form action="/addPerson" method="GET">
		<input type="submit" value="AddPerson" />
	</form>
	<table>
		<tr>
			<th>ID</th>
			<th>firstName</th>
			<th>lastName</th>
			<th>email</th>
			<th>phone</th>
		</tr>
		<c:forEach items="${personList}" var="person">
			<tr>
				<td>${person.id}</td>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>${person.email}</td>
				<td>${person.phone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>