<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" />
<link rel="stylesheet" href="/style.css" />
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<div class="container">
		<%@include file="partials/loggedin.jsp" %>
<h1>The item you tried to create already exists</h1>
<a href="/admin/items">Return to items page</a>
</div>
</body>
</html>