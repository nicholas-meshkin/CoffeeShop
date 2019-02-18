<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-Up</title>
</head>
<body>
	<h1>Register New User</h1>

	<form action="/submit-user-registration">
		<p>
			<label for="firstname">First Name:</label> <input id="firstname" required
				name="firstname" pattern="[A-Za-z]*" />
		</p>
		<p>
			<label for="lastname">Last Name:</label> <input id="lastname" required
				name="lastname" pattern="[A-Za-z]*[\s]*[A-Za-z]" />
		</p>
		<p>
			<label for="email">Email:</label> <input type="email" required id="email"
				name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" />
		</p>
		<p><label for="phone">Phone number:</label> <input required id="phone" name="phone" pattern="[0-9]{3}[-][0-9]{3}[-][0-9]{4}" /></p>
		<p>
			<label for="password">Password:</label> <input type="password" required
				id="password" name="password" />
		</p>
		<p>
			<label for="passwordConf">Password Confirmation:</label> <input
				type="password" required id="passwordConf" required name="passwordConf" />
		</p>
		<fieldset><p>
			<label for="cardtype">Card Type:</label> <select id="cardtype"
				name="cardtype">
			<option value="Visa">Visa</option>
			<option value="Discover">Discover</option>
			<option value="Mastercard">Mastercard</option>
			</select>
		</p>
		<p>
			<label for="creditcardnumber">Credit Card Number:</label> <input
				  id="creditcardnumber"
				name="creditcardnumber" pattern="[0-9]{16}"/>
		</p>
		<p> <label for="cardexp">Card Expiration:</label><input type="date" id="cardexp" name="cardexp"/></p>
		</fieldset>
		<p><label for="sendupdates">Receive offers and updates?</label><input type="checkbox" name="sendupdates" value="yes"/>Yes please!</p>

		<p>
			<button>Submit</button>
		</p>
	</form>
</body>
</html>