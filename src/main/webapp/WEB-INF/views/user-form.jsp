<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-Up</title>
<link rel="stylesheet" href="/style.css" />
</head>
<body>
<h1>Register New User</h1>
<div class="container">
	

	<form action="/submit-user-registration">
		<p>
			<label id="fn" for="firstname">First Name:</label> <input class="inputbox" id="firstname" required
				name="firstname" pattern="[A-Za-z]*" />
		</p>
		<p>
			<label for="lastname">Last Name:</label> <input class="inputbox" id="lastname" required
				name="lastname" pattern="[A-Za-z]*[\s]*[A-Za-z]" />
		</p>
		<p>
			<label for="email">Email:</label> <input class="inputbox" type="email" required id="email"
				name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" />
		</p>
		<p><label for="phone">Phone number:</label> <input class="inputbox" required id="phone" name="phone" pattern="[0-9]{3}[-][0-9]{3}[-][0-9]{4}" /></p>
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
</body>
</html>