package coffeeShopWebApp.CoffeeShop.dao;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import coffeeShopWebApp.CoffeeShop.Item;

@Repository
@Transactional
public class ItemsDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Item> findAll() {
		return em.createQuery("FROM Item", Item.class).getResultList();
	}
	
	public Item findById(Long id) {
		return em.find(Item.class, id);
	}
	
	public void create(Item item) {
		em.persist(item);
	}
	public void update(Item item) {
		em.merge(item);
	}
	public void delete(Long id) {
		Item item = em.getReference(Item.class, id);
		em.remove(item);
	}
	
	public List<String> findNames() {
		List<String> nameList = em.createQuery("SELECT DISTINCT name FROM Item", String.class).getResultList();
				return nameList;
	}
}
