package cart.responseObjects;


import cart.entity.Products;

public class OrderItemDTO {
	
	private int orderItemId;
	
	private Products product;
	
	private int quantity;

	
	
	
	public OrderItemDTO() {
		super();
	}

	public OrderItemDTO(int orderItemId, Products product, int quantity) {
		super();
		this.orderItemId = orderItemId;
		this.product = product;
		this.quantity = quantity;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
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
