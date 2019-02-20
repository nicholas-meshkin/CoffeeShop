<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${ title }</title>
<link rel="stylesheet" href="/style.css" />
</head>
<body>
<h1>${ title }</h1>
<form method="post">
<input type="hidden" name="id" value="${item.id}" />
			<div class="form-group">
			    <label for="name">Name</label>
			    <!-- pre-populate the input value from the existing food (if any) -->
			    <input class="form-control" id="name" name="name" value="${item.name}" required minlength="2" autocomplete="off">
			</div>
			<div class="form-group">
			    <label for="description">Description</label>
			    <input class="form-control" id="description" name="description" value="${item.description}" required>
			</div>
			<div class="form-group">
			    <label for="quantity">Quantity</label>
			    <input class="form-control" id="quantity" name="quantity" value="${item.quantity}"  required>
			</div>
			<div class="form-group">
			    <label for="price">Price</label>
			    <input class="form-control" id="price" name="price" value="${item.price}"  required>
			</div>
			<div class="form-group">
			    <label for="itemimg">Image</label>
			    <input class="form-control" id="itemimg" name="itemimg" value="${item.itemimg}" >
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="/admin/items" class="btn btn-link">Cancel</a>
</form>
</body>
</html>