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

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.SessionAttribute;

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
		Double priceTotal = 0.00;
		for(int i=0;i<myCartItemList.size();i++) {
			priceTotal += myCartItemList.get(i).getPriceTotal();
		}
		ModelAndView mav = new ModelAndView("show-cart");
		mav.addObject("cartItems",myCartItemList);
		 mav.addObject("priceTotal",priceTotal);
//		return new ModelAndView("show-cart","cartItems",myCartItemList);
		 return mav;
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
	
	@PostMapping("/item-list")
	public ModelAndView addToCart(Integer quantity, Long item_id) {
		Item currItem = itemsDao.findById(item_id);
		if(quantity> currItem.getQuantity()) {
			return new ModelAndView("overquantity-error-page"); // this checks if quantity added is over stock, but not if combined quantity is over stock
		}
		
		List<CartItem> list = cartItemsDao.findAll();
		List<Long> idList = new ArrayList<>();
		if(list.size()!=0) {
			for(int i=0;i<list.size();i++) {
				CartItem temp = list.get(i);
			idList.add(temp.getItem().getId());
		}
		}
		System.out.println(list);
		if(idList.contains(item_id)) { 
			CartItem oldcartitem = cartItemsDao.findByItemID(item_id);
			if(oldcartitem.getQuantity()+quantity<= itemsDao.findById(item_id).getQuantity()) {// this should check available quantity and send error message if there aren't enough available
				oldcartitem.setQuantity(quantity+oldcartitem.getQuantity());
				cartItemsDao.update(oldcartitem);
			}else {
				return new ModelAndView("overquantity-error-page");
				}
		}else {
			cartItemsDao.create(quantity, item_id);
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
	public ModelAndView userSubmit(User user, HttpSession session) {
		usersDao.create(user);
		session.setAttribute("profile", user);
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
		List<String> list = itemsDao.findNames();
				if (!list.contains(item.getName())){
		itemsDao.create(item);
		return new ModelAndView("redirect:/admin/items");
		}else {
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
	
	@RequestMapping("/cartitem/delete/conf")
	public ModelAndView cartDeleteConfirmation(@RequestParam("id") Long id) {
		return new ModelAndView("cart-delete-confirmation","id", id);
	}
	
	
	@RequestMapping("/cartitem/delete")
	public ModelAndView cartDeleteItem(@RequestParam("id") Long id) {
		cartItemsDao.delete(id);
		return new ModelAndView("redirect:/cart");
	}
	
}
