<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/style.css" />
<meta charset="ISO-8859-1">
<title>Order Confirmation</title>
</head>
<body>
<h1>Thank you for you order, ${ profile.firstname } ${ profile.lastname }</h1>
<p>Your total of <fmt:formatNumber type="currency" value ="${priceTotal}"/> will be charged to your ${profile.cardtype}</p>
<a href="/">Home</a>
</body>
</html>