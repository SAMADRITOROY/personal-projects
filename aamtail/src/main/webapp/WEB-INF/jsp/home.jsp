<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>aamtail</title>
	</head>
	<body>
		<div>
			<div align="right">		
				<c:choose>
					<c:when test="${empty user}">
						<a href="/login">login</a> | <a href="/signup">sign-up</a>
					</c:when>
					<c:otherwise>
						Welcome ${user.firstName} ${user.lastName} | <a href="/logout">Logout</a> 
					</c:otherwise>
				</c:choose>
			</div>
			<div align="left"><h1>Home Page</h1></div>
		</div>
		<div>
			<table border="1">
				<tr>
					<th>Variety</th>
					<th>Grow in</th>
					<th>Cost/kg</th>
				</tr>
			<c:forEach items="${mangoList}" var="mango"> 
				 <tr>
				   <td>${mango.name}</td>
				   <td>${mango.region}</td>
				   <td>${mango.price}</td>
				 </tr>
			</c:forEach>
			</table>
		</div>
	</body>
</html>