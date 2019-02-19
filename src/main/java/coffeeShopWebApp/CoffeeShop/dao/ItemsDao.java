package coffeeShopWebApp.CoffeeShop.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import coffeeShopWebApp.CoffeeShop.Item;

@Repository
public class ItemsDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Item> findAll() {
		// BeanPropertyRowMapper uses the rows from the SQL result create
		// Use .query for SQL SELECT statements.
		String sql = "SELECT * FROM items";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Item.class));
	}
}
