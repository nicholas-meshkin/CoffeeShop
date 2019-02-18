package coffeeShopWebApp.CoffeeShop;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserList {
	private List<User> userList = new ArrayList<>();
	
	
	
	public void addUser(User user) {
		userList.add(user);
	}

}
