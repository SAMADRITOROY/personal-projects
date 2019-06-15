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
		<h1>Home Page</h1>
		<c:choose>
			<c:when test="${empty user}">
				<a href="/login">login</a> | <a href="/signup">sign-up</a>
			</c:when>
			<c:otherwise>
				Welcome ${user.firstName} ${user.lastName} | <a href="/logout">Logout</a> 
			</c:otherwise>
		</c:choose>
	</body>
</html>