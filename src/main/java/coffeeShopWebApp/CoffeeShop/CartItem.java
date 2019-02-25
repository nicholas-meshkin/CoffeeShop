package coffeeShopWebApp.CoffeeShop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	Item item;
	@ManyToOne
	User user;
	Integer quantity;
	public Double getPriceTotal() {
		Double itemTotal = quantity * item.getPrice();
		return itemTotal;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", item=" + item + ", user=" + user + ", quantity=" + quantity + "]";
	}

	
	

	
	
}
