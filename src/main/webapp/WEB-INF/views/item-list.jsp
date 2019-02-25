<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Items</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" />
<link rel="stylesheet" href="/style.css" />
</head>
<body>
<div class="container">
<%@include file="partials/loggedin.jsp" %>
	<h1>List of Items</h1>
	<table>
		<thead>
			<tr>
				<th class="itemlist">Item</th>
				<th class="itemlist">Description</th>
				<th class="itemlist">Available</th>
				<th class="itemlist">Price</th>
				<th class="itemlist">Image</th>
				<th class="itemlist">Purchase</th>
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
				<td><form method="post">
				<input type="hidden" name="quantity" value=1 />
				<input type="hidden" name="user_id" value="${user.id }"/>
				<input name="item_id" type="hidden" value="${curritem.id}" />
				<button class="btn btn-primary ml-2">Add to Cart</button>
					</form></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="/">Home</a>
	<a href="/cart">Go to Cart</a>
	</div>
</body>
</html>