package coffeeShopWebApp.CoffeeShop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import coffeeShopWebApp.CoffeeShop.CartItem;
import coffeeShopWebApp.CoffeeShop.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import coffeeShopWebApp.CoffeeShop.dao.ItemsDao;


@Repository
@Transactional
public class CartItemsDao {
	
	@Autowired 
	private ItemsDao itemsDao;
	
	@Autowired
	private UsersDao usersDao;

	@PersistenceContext
	private EntityManager em;
	
	public List<CartItem> findByUserId(Long user_id){
		return em.createQuery("FROM CartItem WHERE user.id = :user_id", CartItem.class)
				.setParameter("user_id", user_id).getResultList();
	}
	
	public CartItem findByUserAndItem(Long user_id, Long item_id) {
		System.out.println(user_id);
		System.out.println(item_id);
		CartItem x = em.createQuery("FROM CartItem WHERE user.id = :user_id AND item.id = :item_id", CartItem.class)
				.setParameter("user_id", user_id).setParameter("item_id", item_id).getSingleResult();
		System.out.println(x);
		return x;
	}
	
	public List<CartItem> findAll() {
		return em.createQuery("FROM CartItem", CartItem.class).getResultList();
	}
	public CartItem findByID(Long id) {
		return em.find(CartItem.class, id);
	}
	public CartItem findByItemID(Long item_id){
		return em.createQuery("FROM CartItem WHERE item_id = :item_id", CartItem.class)
				.setParameter("item_id", item_id).getSingleResult();				
	}
	
	public void create(Integer quantity, Long item_id, Long user_id) {
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(quantity);
		cartItem.setItem(itemsDao.findById(item_id));
		cartItem.setUser(usersDao.findById(user_id));
		em.persist(cartItem);
	}
	
	public void update(CartItem cartItem) {
		em.merge(cartItem);
	}
	
	public CartItem findByItem(Item item) {
		return em.createQuery("FROM CartItem WHERE item = :fart", CartItem.class).setParameter("fart", item).getSingleResult();
		
	}
	
	public void delete(Long id) {
		CartItem cartItem = em.getReference(CartItem.class, id);
		em.remove(cartItem);
	}
	
	public void deleteAll() {
		em.createQuery("DELETE FROM CartItem").executeUpdate();
	}
	
	public void deleteCart(Long user_id) {
		List<CartItem> list = em.createQuery("FROM CartItem WHERE user.id = :user_id", CartItem.class).setParameter("user_id", user_id).getResultList();
		for(CartItem cartItem : list) {
			em.remove(cartItem);
		}
	}
	
//	public List<Long> findItemIds() {
//		List<Long> idList = em.createQuery("SELECT DISTINCT tem FROM CartItem", Long.class).getResultList();
//				return idList;
//	}
}
