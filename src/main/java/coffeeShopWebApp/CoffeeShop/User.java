package coffeeShopWebApp.CoffeeShop;

public class User {
	private Long id;
	
	private String firstname;
	private String lastname;
	private String phone;
	private String password;
	private String email;
	private String creditcard;
	private String cardtype;
	private String cardexp;
	
	public User() {}

	
	public User(Long id, String firstname, String lastname, String phone, String password, String email, String cardtype, String creditcardnumber, String cardexp) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.password = password;
		this.email = email;
		this.cardtype = cardtype;
		this.creditcard = creditcard;
		this.cardexp=cardexp;
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCreditcard() {
		return creditcard;
	}


	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}


	public String getCardtype() {
		return cardtype;
	}


	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}


	public String getCardexp() {
		return cardexp;
	}


	public void setCardexp(String cardexp) {
		this.cardexp = cardexp;
	}


	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", password=" + password
				+ ", email=" + email + "]";
	}

}
