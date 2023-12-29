package cart.responseObjects;

import cart.entity.Products;

public class GetCartItem {
	private int cartItemId;
	private Products product;
	private int quantity;
	
	
	public GetCartItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GetCartItem(int cartItemId, Products product, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.product = product;
		this.quantity = quantity;
	}


	public int getCartItemId() {
		return cartItemId;
	}


	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}


	public Products getProduct() {
		return product;
	}


	public void setProduct(Products product) {
		this.product = product;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
