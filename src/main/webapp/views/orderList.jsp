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
	<form action="/secure" method="GET">
		<input type="submit" value="Back" />
	</form>
	<a href="<c:url value="/addOrder" />"> Add order</a>
	<table>
		<tr>
			<th>Order ID</th>
			<th>Date</th>
			<th>Person id</th>
			<th>firstName</th>
		</tr>
		<c:forEach items="${orderList}" var="order">
			<tr>
				<td>${order.id}</td>
				<td>${order.orderDate}</td>
				<td>${order.person.id}</td>
				<td>${order.person.firstName}</td>
				<td><form action="/addOrderLine/${order.id}" method="GET">
						<input type="submit" value="Add orderLine" />
					</form></td>
				<td>
					<table>
						<tr>
						<th>Order line id</th>
							<th>Quantity</th>
							<th>product Name</th>
							<th>product id</th>
							<th>price</th>
							
						</tr>
						<c:forEach items="${order.orderLines}" var="orderLine">
							<tr>
							<td>${orderLine.id}</td>
								<td>${orderLine.quantity}</td>
								<td>${orderLine.product.productName}</td>
								<td>${orderLine.product.id}</td>
								<td>${orderLine.product.price}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
				<td><form action="/deleteOrder/${order.id}" method="GET">
						<input type="submit" value="Delete" />
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>