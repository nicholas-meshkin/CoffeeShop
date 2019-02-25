<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-Up</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" />
<link rel="stylesheet" href="/style.css" />
</head>
<body>
<div class="container">
<h1>Register New User</h1>
<p class="message">${ message }</p>
<div class="container">
	

	<form action="user-registration" method="post">
	<input type="hidden" name="usertype" value="reguser" />
		<p>
			<label id="fn" for="firstname">First Name:</label> <input class="inputbox" id="firstname" required
				name="firstname" value="${ param.firstname }"pattern="[A-Za-z]*" />
		</p>
		<p>
			<label for="lastname">Last Name:</label> <input class="inputbox" id="lastname" required
				name="lastname" value="${ param.lastname }" pattern="[A-Za-z]*[\s]*[A-Za-z]" />
		</p>
		<p>
			<label for="username">User Name:</label> <input class="inputbox" id="username" required
				name="username"  value="${ param.username }" pattern="[A-Za-z0-9]*" />
		</p>
		<p>
			<label for="email">Email:</label> <input class="inputbox" type="email" required id="email"
				name="email" value="${ param.email }" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" />
		</p>
		<p>
		<label for="phone">Phone number:</label> <input class="inputbox" required id="phone" name="phone" value="${ param.email }" pattern="[0-9]{3}[-][0-9]{3}[-][0-9]{4}" />
		</p>
		<p>
			<label for="password">Password:</label> <input class="inputbox" type="password" required
				id="password" name="password" />
		</p>
		<p>
			<label for="passwordConf">Password Confirmation:</label> <input class="inputbox" 
				type="password" required id="passwordConf" required name="passwordConf" />
		</p>
			<!--<fieldset>-->
		<p>
			<label for="cardtype">*Card Type:</label> <select class="inputbox" id="cardtype"
				name="cardtype">
				<option value=""></option>
			<option value="Visa">Visa</option>
			<option value="Discover">Discover</option>
			<option value="Mastercard">Mastercard</option>
			</select>
		</p>
		<p>
			<label for="creditcard">*Credit Card Number:</label> <input class="inputbox" 
				  id="creditcard"
				name="creditcard" pattern="[0-9]{16}"/>
		</p>
		<p> <label for="cardexp">*Card Expiration:</label> <input class="inputbox" type="date" id="cardexp" name="cardexp"/></p>
		<!-- </fieldset> -->
		<p><label for="sendupdates">*Receive offers and updates?</label><input id="checkbox" type="checkbox" name="sendupdates" value="yes"/>Yes please!</p>

		<p>
			<button>Submit</button>
		</p>
	</form>
	</div>
	<p><br></p>
	<p><br></p>
	<p id=footer>*optional fields</p>
	</div>
</body>
</html>