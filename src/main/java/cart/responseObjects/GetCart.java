package cart.responseObjects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class GetCart {
	@JsonProperty("userId")
	private int userId;
	
	@JsonProperty("products")
	private List<GetCartItem> cartItems;
	
	@JsonProperty("totalPrice")
	private int totalPrice;
	
	
	

	public GetCart() {
		super();
	}




	public GetCart(int userId, List<GetCartItem> cartItems, int totalPrice) {
		super();
		this.userId = userId;
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
	}




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public List<GetCartItem> getCartItems() {
		return cartItems;
	}




	public void setCartItems(List<GetCartItem> cartItems) {
		this.cartItems = cartItems;
	}




	public int getTotalPrice() {
		return totalPrice;
	}




	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
	
	
	
	
		
}
