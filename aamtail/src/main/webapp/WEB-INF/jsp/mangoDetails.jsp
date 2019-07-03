<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Mango Details</title>
	</head>
	<body>
		<div align="right">
			<a href="/">Home</a>
		</div>
		<h1>${mango.name}</h1>
		<h2>From: ${mango.region}</h2>
		<form:form action="${mango.name}/addToCart" modelAttribute="orderItem">
			<table border="1">
				<tr>
					<th>Price/kg</th>
					<th>Quantity</th>
					<th></th>
				</tr>
				<tr>
					<td>${mango.price}</td>
					<td><form:input path="quantity" /> kg</td>
					<td><input type="submit" value="Add To Cart" /></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>