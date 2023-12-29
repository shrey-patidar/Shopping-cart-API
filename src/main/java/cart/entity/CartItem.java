package cart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserProfile userProfile;
	
	@OneToOne
	@JoinColumn(name = "productId")
	private Products products;
	
	private int quantity;

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(int cartItemId, UserProfile userProfile, Products products, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.userProfile = userProfile;
		this.products = products;
		this.quantity = quantity;
	}

	public CartItem(UserProfile userProfile, Products products, int quantity) {
		super();
//		this.cartItemId = cartItemId;
		this.userProfile = userProfile;
		this.products = products;
		this.quantity = quantity;
	}
	
	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	
}
