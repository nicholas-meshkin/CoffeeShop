package coffeeShopWebApp.CoffeeShop.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import coffeeShopWebApp.CoffeeShop.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Repository
@Transactional
public class UsersDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void create(User user) {
		em.persist(user);
	}

}
