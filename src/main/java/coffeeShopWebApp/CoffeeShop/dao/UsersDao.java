package coffeeShopWebApp.CoffeeShop.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import coffeeShopWebApp.CoffeeShop.User;

@Repository
public class UsersDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	
	public void create(User user) {
		String sql = "INSERT INTO users (firstname, lastname, phone, password, email, creditcard, cardtype, cardexp) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbc.update(sql,user.getFirstname(),user.getLastname(),user.getPhone(), user.getPassword(),user.getEmail(),user.getCreditcard(),user.getCardtype(),user.getCardexp());
	}

}
