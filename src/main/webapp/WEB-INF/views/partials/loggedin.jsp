<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<a href="/">Home</a>
	
	<span>
	<c:choose>
		<c:when test="${ not empty user }">
			Welcome, ${ user.username }
			<a href="/logout">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="/login">Sign In</a>
			<a href="/user-registration">Sign Up</a>
		</c:otherwise>
	</c:choose>
	</span>
</header>