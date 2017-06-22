<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Create order
	<form action="/secure" method="GET">
		<input type="submit" value="Back" />
	</form>
	<form action="/createOrder" method="POST">
	
		<select name="personId">
			<c:forEach items="${personList}" var="person">
				<option  value="${person.id}">${person.firstName}</option>
			</c:forEach>
		</select> <input type="submit" value="Add product" />
	</form>
</body>
</html>