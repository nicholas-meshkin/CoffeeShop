package coffeeShopWebApp.CoffeeShop;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	// home page
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	// admin menu page
	@RequestMapping("/admin")
	public ModelAndView adminPage(@SessionAttribute(name="user", required=false) User user) {
		if (user!=null && user.getUsertype().equals("admin")) {
		return new ModelAndView("admin-page");
		}else {
			return new ModelAndView("access-error");
		}
	}

	//login page
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}
	@PostMapping("/login")
	public ModelAndView submitLogin(@RequestParam("username") String username,
									@RequestParam("password") String password,
										HttpSession session, RedirectAttributes redir) {
		User user = usersDao.findByUsername(username);
		if(user==null || !user.getPassword().equals(password)) {
			return new ModelAndView("login","message","incorrect username or password");
			}
		session.setAttribute("user", user);
		
		redir.addFlashAttribute("message", "Welcome, thx for logging in");
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		session.invalidate();
		redir.addFlashAttribute("Logged Out");
		return new ModelAndView("redirect:/");
	}
	
	// view cart page
	@RequestMapping("/cart")
	public ModelAndView cartPage(@SessionAttribute(name="user", required=false) User user) {
		if(user!=null) {
		List<CartItem> myCartItemList = cartItemsDao.findByUserId(user.getId());
		Double priceTotal = 0.00;
		for (int i = 0; i < myCartItemList.size(); i++) {
			priceTotal += myCartItemList.get(i).getPriceTotal();
		}
		ModelAndView mav = new ModelAndView("show-cart");
		mav.addObject("cartItems", myCartItemList);
		mav.addObject("priceTotal", priceTotal);
//		return new ModelAndView("show-cart","cartItems",myCartItemList);
		return mav;
		}else {return new ModelAndView("login-request");}
	}

	// list of items you can update, delete, or add
	@RequestMapping("/admin/items")
	public ModelAndView itemAdmin(@SessionAttribute(name="user", required=false) User user) {
			if (user!=null && user.getUsertype().equals("admin")) {
				List<Item> myItemList = itemsDao.findAll();
				return new ModelAndView("item-list-admin", "items", myItemList);
			}else {
				return new ModelAndView("access-error");
			}
	}

	// page for users to add items to cart
	@RequestMapping("/item-list")
	public ModelAndView listItems() {
		List<Item> myItemList = itemsDao.findAll();
		return new ModelAndView("item-list", "items", myItemList);
	}
	@PostMapping("/item-list")
	public ModelAndView addToCart(@SessionAttribute(name="user", required=false) User user, Integer quantity, Long item_id, Long user_id) {
		if (user!=null) {
			
		
		Item currItem = itemsDao.findById(item_id);
		if (quantity > currItem.getQuantity()) {
			return new ModelAndView("overquantity-error-page"); // this checks if quantity added is over stock, but not
																// if combined quantity is over stock
		}

		List<CartItem> list = cartItemsDao.findByUserId(user_id);
		List<Long> idList = new ArrayList<>();
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) { // this gets a list of item IDs from the cartItems in the cart to
													// check whether to create a new entry or update the quantity of an
													// old one
				CartItem temp = list.get(i);
				idList.add(temp.getItem().getId());
			}
		}
		System.out.println(list);
		if (idList.contains(item_id)) {
			CartItem oldcartitem = cartItemsDao.findByUserAndItem(user_id, item_id);
			
			// this checks available quantity and send error message if there aren't enough available
			if (oldcartitem.getQuantity() + quantity <= itemsDao.findById(item_id).getQuantity() && quantity > 0) {
				oldcartitem.setQuantity(quantity + oldcartitem.getQuantity());
				cartItemsDao.update(oldcartitem);
			} else {
				return new ModelAndView("overquantity-error-page");
			}
		} else {
			cartItemsDao.create(quantity, item_id, user_id);
		}
		return new ModelAndView("redirect:/item-list");
		}else {return new ModelAndView("login-request");}
	}

	// admin page for updating items
	@RequestMapping("/item/update")
	public ModelAndView showUpdateForm(@RequestParam("id") Long id,@SessionAttribute(name="user", required=false) User user) {
			if (user!=null && user.getUsertype().equals("admin")) {
				ModelAndView mav = new ModelAndView("item-form");
				mav.addObject("item", itemsDao.findById(id));
				mav.addObject("title", "Edit Items");
				return mav;
			}else {
				return new ModelAndView("access-error");
			}
		}
	

	@PostMapping("/item/update")
	public ModelAndView submitUpdate(Item item) {
		itemsDao.update(item);
		return new ModelAndView("redirect:/admin/items");
	}

	@RequestMapping("/cart/quantity-update")
	public ModelAndView showQuantityUpdateForm(@RequestParam("id") Long id, @SessionAttribute(name="user", required=false) User user) {
		ModelAndView mav = new ModelAndView("update-cart-quantity-form");
		mav.addObject("cartItem", cartItemsDao.findByUserAndItem(user.getId(), cartItemsDao.findByID(id).getItem().getId()));
		return mav;
	}

	@PostMapping("/cart/quantity-update")
	public ModelAndView submitQuantityUpdate(Integer quantity, Long id, @SessionAttribute(name="user", required=false) User user) {
		if (quantity <= cartItemsDao.findByID(id).getItem().getQuantity() && quantity > 0) { // checks to make sure the
																								// new quantity is valid
			CartItem tempCartItem = cartItemsDao.findByUserAndItem(user.getId(), cartItemsDao.findByID(id).getItem().getId());
			tempCartItem.setQuantity(quantity);
			cartItemsDao.update(tempCartItem);
			return new ModelAndView("redirect:/cart");
		} else {
			return new ModelAndView("overquantity-error-page");
		}
	}

	// page for entering user info
	@RequestMapping("/user-registration")
	public ModelAndView userReg() {
		return new ModelAndView("user-form");
	}
	// creates the session and sends to registration confirmation page
		@PostMapping("/user-registration")
		public ModelAndView userSubmit(User user, @RequestParam("passwordConf") String passwordConf,HttpSession session, RedirectAttributes redir) {
			User userCheck = usersDao.findByUsername(user.getUsername());
			if (userCheck != null) {
				return new ModelAndView("user-form", "message", "A user with that username already exists.");
			}
			
			if (!passwordConf.equals(user.getPassword())) {
				return new ModelAndView("user-form", "message", "Passwords do not match.");
			}
			
			usersDao.create(user);
			session.setAttribute("user", user);
			String firstname = user.getFirstname();
			ModelAndView mav = new ModelAndView("user-confirmation");
			mav.addObject("firstname", firstname);
			return mav;
		}

	// page letting user know they have been registered -- this link may be obsolete
	@RequestMapping("/user-confirmation")
	public ModelAndView userConf() {
		return new ModelAndView("user-confirmation");
	}

	

	// add item page
	@RequestMapping("/addItem")
	public ModelAndView addItem(@SessionAttribute(name="user", required=false) User user) {
			if (user!=null && user.getUsertype().equals("admin")) {
				return new ModelAndView("item-form", "title", "Add an Item");
			}else {
				return new ModelAndView("access-error");
			}
	}
	

	@PostMapping("/addItem")
	public ModelAndView submitNewItem(Item item) {
		List<String> list = itemsDao.findNames();
		if (!list.contains(item.getName())) {
			itemsDao.create(item);
			return new ModelAndView("redirect:/admin/items");
		} else {
			return new ModelAndView("error-page");
		}
	}

	// delete confirmation page
	@RequestMapping("/item/delete/conf")
	public ModelAndView deleteConfirmation(@RequestParam("id") Long id) {
		return new ModelAndView("delete-confirmation", "id", id);
	}

	// thing that actually deletes the item
	@RequestMapping("/item/delete")
	public ModelAndView deleteItem(@RequestParam("id") Long id,@SessionAttribute(name="user", required=false) User user) {
			if (user!=null && user.getUsertype().equals("admin")) {
				itemsDao.delete(id);
				return new ModelAndView("redirect:/admin/items");
			}else {
				return new ModelAndView("access-error");
			}
	}

	// delete confirmation page
	@RequestMapping("/cartitem/delete/conf")
	public ModelAndView cartDeleteConfirmation(@RequestParam("id") Long id) {
		return new ModelAndView("cart-delete-confirmation", "id", id);
	}

	// thing that actually deletes the item
	@RequestMapping("/cartitem/delete")
	public ModelAndView cartDeleteItem(@RequestParam("id") Long id) {
		cartItemsDao.delete(id);
		return new ModelAndView("redirect:/cart");
	}

	@RequestMapping("/checkout")
	public ModelAndView checkout(@SessionAttribute(name="user", required=false) User user) {
		Double priceTotal = 0.00;
		List<CartItem> myCartItemList = cartItemsDao.findAll();
		for (int i = 0; i < myCartItemList.size(); i++) {
			priceTotal += myCartItemList.get(i).getPriceTotal();
		}
		// should probably have something that updates item stock, adds order to another
		// database, and comfirms cc info
		cartItemsDao.deleteCart(user.getId());
		return new ModelAndView("order-confirmation", "priceTotal", priceTotal);

	}

}
