<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/style.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Item Quantity</h1>

	<div>${cartItem.item.name}</div>
	<div><fmt:formatNumber type="currency" value ="${cartItem.item.price}"/></div>
	<form method="post">
		<input type="hidden" name="id" value="${cartItem.id}" />
		<div class="form-group">
			<label for="quantity">Quantity</label> <input class="form-control"
				id="quantity" name="quantity" value="${item.quantity}" required>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
		<a href="/cart" class="btn btn-link">Cancel</a>
	</form>
</body>
</html>