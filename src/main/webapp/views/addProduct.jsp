<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Create product
	<form action="/secure" method="GET" >
		<input type="submit" value="Back" />
	</form>
	<form action="/createProduct" method="POST" >
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		Description: <input type="text" name="description"> <br /> 
		Price: <input type="text" name="price"> <br /> 
		Product name: <input type="text" name="productName" /> <br />	
		Product type: <input type="text" name="productType"> <br /> 
		<input type="submit" value="Add product" />
	</form>
</body>
</html>