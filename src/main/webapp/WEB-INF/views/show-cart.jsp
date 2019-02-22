<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/style.css" />
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
<header><span>
			Welcome, ${ profile.firstname } ${ profile.lastname }
		</span></header>
<h1>Your Cart</h1>
	<table>
		<thead>
			<tr>
			<th class="itemlist">Quantity</th>
				<th class="itemlist">Item</th>
				<th class="itemlist">Price</th>
			</tr>
		</thead>
		</tbody>
		<c:forEach var="currcartitem" items="${cartItems}">
			<tr>
			<!-- 	<td><a href="/rooms/${classroom.id}">${classroom.name}</a></td> this is how I could make a link-->
				<td class="itemlist">${currcartitem.quantity}</td>
				<td class="itemlist" >${currcartitem.item.name}</td>
				<td class="itemlist"><fmt:formatNumber type="currency" value = "${currcartitem.priceTotal}" /></td>
				<td>
						<!-- update this for cart <a href="/item/update?id=${ curritem.id }" class="btn btn-light btn-sm">Edit</a>-->
						<a href="/cartitem/delete/conf?id=${ currcartitem.id }" class="btn btn-light btn-sm">Delete</a>
					</td>
					</tr>
		</c:forEach>
		</tbody>
	</table>
	<p>Total: <span><fmt:formatNumber type="currency" value = "${priceTotal }"></fmt:formatNumber></span></p>
<a href="/">Home</a>
<a href="/item-list">Back to Item List</a>
<a href="/checkout">Check Out</a>
</body>
</html>