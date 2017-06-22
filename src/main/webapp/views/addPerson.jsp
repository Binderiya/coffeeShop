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
	<form action="/createPerson" method="POST" >
		firstName: <input type="text" name="firstName"> <br /> 
		lastName: <input type="text" name="lastName"> <br /> 
		email: <input type="text" name="email" /> <br />	
		role: <input type="text" name="role" /> <br />	
		city: <input type="text" name="city"> <br /> 
		state: <input type="text" name="state"> <br /> 
		country: <input type="text" name="country"> <br /> 
		zipcode: <input type="text" name="zipcode"> <br /> 
		phone: <input type="text" name="phone"> <br /> 
		enable: <input type="text" name="enable"> <br /> 
		<input type="submit" value="Add product" />
	</form>
</body>
</html>