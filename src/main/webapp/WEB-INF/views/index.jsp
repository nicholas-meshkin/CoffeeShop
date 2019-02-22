<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="/style.css" />
</head>
<body>
<header><span>
			Welcome, ${ profile.firstname } ${ profile.lastname }
		</span></header>
<h1>Welcome to Nick's Coffee Website!</h1>
<p><a href="/user-registration">User Registration</a></p>
<p><a href="/item-list">List of Items</a></p>
<p><a href="/admin">Admin</a></p>
</body>
</html>