package coffeeShopWebApp.CoffeeShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeController {

	@Autowired
	UserList userList;
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
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
		userList.addUser(user);
		String firstname = user.getFirstname();
		ModelAndView mav = new ModelAndView("user-confirmation");
		mav.addObject("firstname",firstname);
		return mav;
		
	}
	
}
