<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>My Cart</title>
	</head>
	<body>
		<div align="right">
			<a href="/">Home</a>
		</div>
		<h1>My Cart</h1>
		<c:choose>
			<c:when test="${empty cart.items}">
				Your cart is empty.
			</c:when>
			<c:otherwise> 
				<table border="1">
					<tr>
						<th>Variety</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Amount</th>
					</tr>
					<c:set var="cartTotal" value="${0}" />
					<c:forEach items="${cart.items}" var="orderItem">
						<tr>
							<td>${orderItem.mango.name}</td>
							<td>${orderItem.mango.price}</td>
							<td>${orderItem.quantity}</td>
							<td>${orderItem.mango.price * orderItem.quantity}</td>
						</tr>
						<c:set var="cartTotal" 
							value="${cartTotal + 
								orderItem.mango.price * orderItem.quantity}" />
					</c:forEach>
					<tr>
						<td colspan="3">Total Cart Value => </td>
						<td><c:out value="${cartTotal}"/></td>
					</tr>
					<tr>
						<td colspan="4">
							<a href="/buyCart">BuyNow</a>
						</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</body>
</html>