<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>aamtail</title>
	</head>
	<body>
		<div align="right">		
			<c:choose>
				<c:when test="${empty user}">
					<a href="/login">login</a> | <a href="/signup">sign-up</a>
				</c:when>
				<c:otherwise>
					Welcome ${user.firstName} ${user.lastName} | <a href="/cart">My Cart</a> | <a href="/logout">Logout</a> 
				</c:otherwise>
			</c:choose>
		</div>
		<h1>Home Page</h1>
		<table border="1">
			<tr>
				<th>Variety</th>
			</tr>
			<c:forEach items="${mangoList}" var="mango"> 
				<tr>
					<td><a href="/mangoes/${mango.name}">${mango.name}</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>