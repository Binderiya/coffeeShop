<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Create person
	<form action="/secure" method="GET" >
		<input type="submit" value="Back" />
	</form>
	<form action="/login" method="GET" >
		userName: <input type="text" name="userName"> <br /> 
		password: <input type="text" name="password"> <br /> 
		<input type="submit" value="Login" />
	</form>
</body>
</html>