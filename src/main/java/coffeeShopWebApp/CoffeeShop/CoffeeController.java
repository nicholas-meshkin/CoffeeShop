package coffeeShopWebApp.CoffeeShop;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import coffeeShopWebApp.CoffeeShop.dao.ItemsDao;
import coffeeShopWebApp.CoffeeShop.dao.UsersDao;
import coffeeShopWebApp.CoffeeShop.dao.CartItemsDao;

@Controller
public class CoffeeController {

	@Autowired
	private UsersDao usersDao;
	
	@Autowired 
	private ItemsDao itemsDao;
	
	@Autowired
	private CartItemsDao cartItemsDao;
	
	
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/admin")
	public ModelAndView adminPage() {
		return new ModelAndView("admin-page");
	}
	
	@RequestMapping("/cart")
	public ModelAndView cartPage() {
		List<CartItem> myCartItemList = cartItemsDao.findAll();
		return new ModelAndView("show-cart","cartItems",myCartItemList);
	}
	
	
	
	@RequestMapping("/admin/items")
	public ModelAndView itemAdmin() {
		List<Item> myItemList = itemsDao.findAll();
		return new ModelAndView("item-list-admin","items",myItemList);
	}
	
	@RequestMapping("/item-list")
	public ModelAndView listItems() {
		List<Item> myItemList = itemsDao.findAll();
		return new ModelAndView("item-list","items",myItemList);
	}
	
	/*
	 * CartItem old = dao.findByItem
	 * int newQuant= old.getQuant+newCI.getQuant;
	 * old.setQuantity(newQuant)
	 * dao.update(old);
	 * 
	 * CartItem odl = dao.findByItem
	 * newCI.setId(old.getId())
	 * newCI.setQuantity(..
	 * dao.update(newCI)
	 */
	
	@PostMapping("/item-list")
	public ModelAndView addToCart(CartItem cartItem, Long item_id) {
		List<Item> list = cartItemsDao.findAllItems();
		if(list.contains(cartItem.getItem())) { //need to get list of item ids and compare them to m
			//update
			CartItem olditem = cartItemsDao.findByItem(cartItem.getItem());
			olditem.setQuantity(cartItem.getQuantity()+olditem.getQuantity());
			cartItemsDao.update(olditem);
		}
//		This didn't work, threw back an error
//		List<Item> list = cartItemsDao.findAllItems();
//		List<Long> idList = new ArrayList<>();
//		if(list.size()!=0) {
//			for(int i=0;i<list.size();i++) {
//			idList.add(list.get(i).getId());
//		
//		}
//		}
//		if(idList.contains(item_id)) { //need to get list of item ids and compare them to the long parameter
//		
//			//update
//			CartItem olditem = cartItemsDao.findByItem(cartItem.getItem());
//			olditem.setQuantity(cartItem.getQuantity()+olditem.getQuantity());
//			cartItemsDao.update(olditem);
//		}
		
		else {
			cartItemsDao.create(cartItem, item_id);
		}
		
		return new ModelAndView("redirect:/item-list");
	}
	
	@RequestMapping("/item/update")
	public ModelAndView showUpdateForm(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("item-form");
		mav.addObject("item", itemsDao.findById(id));
		mav.addObject("title", "Edit Items");
		return mav;
	}
	
	@PostMapping("/item/update")
	public ModelAndView submitUpdate(Item item) {
		itemsDao.update(item);
		return new ModelAndView("redirect:/admin/items");
		
	}
	
	@RequestMapping("/user-registration")
	public ModelAndView userReg() {
		return new ModelAndView("user-form");
	}
	
	@RequestMapping("/user-confirmation")
	public ModelAndView userConf() {
		
		return new ModelAndView("user-confirmation");
	}
	
	@RequestMapping("/submit-user-registration")
	public ModelAndView userSubmit(User user) {
		usersDao.create(user);
		String firstname = user.getFirstname();
		ModelAndView mav = new ModelAndView("user-confirmation");
		mav.addObject("firstname",firstname);
		return mav;
		
	}
	@RequestMapping("/addItem")
		public ModelAndView addItem() {
		return new ModelAndView("item-form","title","Add an Item");
	}
	@PostMapping("/addItem")
	public ModelAndView submitNewItem(Item item) {
		List list = itemsDao.findNames();
				if (!list.contains(item.getName())){
		itemsDao.create(item);
		return new ModelAndView("redirect:/admin/items");
		}
		else {
			return new ModelAndView("error-page");
		}
		
		
	}
	@RequestMapping("/item/delete/conf")
	public ModelAndView deleteConfirmation(@RequestParam("id") Long id) {
		return new ModelAndView("delete-confirmation","id", id);
	}
	
	
	@RequestMapping("/item/delete")
	public ModelAndView deleteItem(@RequestParam("id") Long id) {
		itemsDao.delete(id);
		return new ModelAndView("redirect:/admin/items");
	}
	
}
