<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" />
<link rel="stylesheet" href="/style.css" />
<meta charset="ISO-8859-1">
<title>Change Quantity</title>
</head>
<body>
<div class="container">
		<%@include file="partials/loggedin.jsp" %>
	<h1>Update Item Quantity</h1>

	<div>${cartItem.item.name}</div>
	<div><fmt:formatNumber type="currency" value ="${cartItem.item.price}"/></div>
	<form method="post">
		<input type="hidden" name="item_id" value="${cartItem.id}" />
		<input type="hidden" name="user_id" value="${user.id }"/>
		<div class="form-group">
			<label for="quantity">Quantity</label> <input class="quantity-box"
				id="quantity" name="quantity" value="${cartItem.quantity}" required>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
		<a href="/cart" class="btn btn-link">Cancel</a>
	</form>
	</div>
</body>
</html>