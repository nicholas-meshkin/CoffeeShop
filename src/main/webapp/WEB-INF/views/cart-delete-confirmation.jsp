<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/style.css" />
<title>Delete Confirmation</title>
</head>
<body>
<h1>Are you sure you want to delete this item?</h1>
<a href="/cartitem/delete?id=${ id }">Yes</a>
<a href="/cart">No</a>
</body>
</html>