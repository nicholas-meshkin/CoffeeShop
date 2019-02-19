<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Items</title>
</head>
<body>
	<h1>List of Items</h1>
	<table>
		<thead>
			<tr>
				<th>Item</th>
				<th>Description</th>
				<th>Quantity Available</th>
				<th>Price</th>
			</tr>
		</thead>
		</tbody>
		<c:forEach var="curritem" items="${items}">
			<tr>
			<!-- 	<td><a href="/rooms/${classroom.id}">${classroom.name}</a></td> -->
				<td>${curritem.name}</td>
				<td>${curritem.description}</td>
				<td>${curritem.quantity}</td>
				<td>${curritem.price}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="/">Home</a>
</body>
</html>