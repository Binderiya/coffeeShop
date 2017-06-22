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
	<form action="/updateInfo/${person.id}" method="POST" >
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		firstName: <input type="text" name="firstName" value="${person.firstname}"> <br /> 
		lastName: <input type="text" name="lastName" value="${person.lastname}"> <br /> 
		email: <input type="text" name="email" value="${person.email}"/> <br />	
		city: <input type="text" name="city"value="${person.city}"> <br /> 
		state: <input type="text" name="state" value="${person.state}"> <br /> 
		country: <input type="text" name="country" value="${person.country}"> <br /> 
		zipcode: <input type="text" name="zipcode" value="${person.zipcode}"> <br /> 
		phone: <input type="text" name="phone" value="${person.phone}"> <br /> 
		enable: <input type="text" name="enable" value="${person.enable}"> <br /> 
		username: <input type="text" name="username" value="${person.username}"> <br /> 
		password: <input type="text" name="password" value="${person.password}"> <br /> 
		password: <input type="text" name="passwordConfirm" value="${person.passwordConfirm}"> <br /> 
		role: <input type="text" name="role" value="${person.role}"> <br /> 
		<input type="submit" value="Add product" />
	</form>
</body>
</html>