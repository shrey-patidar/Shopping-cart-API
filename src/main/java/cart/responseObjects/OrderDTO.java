package cart.responseObjects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDTO {
	@JsonProperty("orderId")
	private int orderId;
	
	@JsonProperty("products")
	private List<OrderItemDTO> orderitems;

	
	
	
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(int orderId, List<OrderItemDTO> orderitems) {
		super();
		this.orderId = orderId;
		this.orderitems = orderitems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderItemDTO> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<OrderItemDTO> orderitems) {
		this.orderitems = orderitems;
	}
	
	
	
}
