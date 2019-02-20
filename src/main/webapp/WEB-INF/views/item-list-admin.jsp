<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Items</title>
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<h1>List of Items</h1>
	<table>
		<thead>
			<tr>
				<th class="itemlist">Item</th>
				<th class="itemlist">Description</th>
				<th class="itemlist">Quantity Available</th>
				<th class="itemlist">Price</th>
				<th class="itemlist">Image</th>
			</tr>
		</thead>
		</tbody>
		<c:forEach var="curritem" items="${items}">
			<tr>
			<!-- 	<td><a href="/rooms/${classroom.id}">${classroom.name}</a></td> this is how I could make a link-->
				<td class="itemlist" >${curritem.name}</td>
				<td class="itemlist">${curritem.description}</td>
				<td class="itemlist">${curritem.quantity}</td>
				<td class="itemlist"><fmt:formatNumber type="currency" value = "${curritem.price}" /></td>
				<td class="itemlist"><img class="img" src="/images/${curritem.itemimg }"></td>
				<td>
						<a href="/item/update?id=${ curritem.id }" class="btn btn-light btn-sm">Edit</a>
						<a href="/item/delete/conf?id=${ curritem.id }" class="btn btn-light btn-sm">Delete</a>
					</td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="/addItem">Add an Item</a>
	<a href="/">Home</a>
</body>
</html>