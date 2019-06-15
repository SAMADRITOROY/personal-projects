<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login to aamtail</title>
	</head>
	<body>
		<h1>Login</h1>
			<c:choose>
				<c:when test="${!empty errorString}">
					${errorString}
				</c:when>
			</c:choose>
			<form:form action="signup" modelAttribute="user">
				<table>
					<tr>
						<td>Username:</td>
						<td><form:input path="username" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:password path="password" /></td>
					</tr>
					<tr>
						<td>First Name:</td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td>Email Id:</td>
						<td><form:input path="emailId" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="Submit">
						</td>
					</tr>
				</table>
			</form:form>
	</body>
</html>