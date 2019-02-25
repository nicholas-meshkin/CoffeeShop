<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" />
<link rel="stylesheet" href="/style.css" />
<meta charset="ISO-8859-1">
<title>Delete Confirmation</title>
</head>
<body>
<h1>Are you sure you want to delete this item?</h1>
<a href="/item/delete?id=${ id }">Yes</a>
<a href="/admin/items">No</a>
</body>
</html>