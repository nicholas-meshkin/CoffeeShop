<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" />

</head>
<body>

<div class="container">
<%@include file="partials/loggedin.jsp" %>
<h1>Welcome to Nick's Coffee Website!</h1>
<p class="message">${ message }</p>
<p><a href="/user-registration">User Registration</a></p>
<p><a href="/login">Sign-in</a></p>
<p><a href="/item-list">List of Items</a></p>
<c:choose>
<c:when test="${ not empty user and user.usertype == 'admin' }">
<p><a href="/admin">Admin</a></p>
</c:when>
</c:choose>
</div>
</body>
</html>