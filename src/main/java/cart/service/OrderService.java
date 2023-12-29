package cart.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cart.entity.CartItem;
import cart.entity.OrderItems;
import cart.entity.Orders;
import cart.entity.UserProfile;
import cart.repository.CartItemRepository;
import cart.repository.OrderItemsRepository;
import cart.repository.OrdersRepository;
import cart.repository.UserProfileRepository;
import cart.responseObjects.OrderDTO;
import cart.responseObjects.OrderItemDTO;

@Service
public class OrderService {
	
	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private OrderItemsRepository orderItemsRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	

	public OrderDTO createOrder(int userId) {
		
		UserProfile user=userProfileRepository.findById(userId);
		Orders temp_order=new Orders();
		temp_order.setUserProfile(user);
		Orders createdOrder= ordersRepository.save(temp_order);
		
		List<OrderItemDTO> currentOrderItems= new ArrayList<>();
		
		List<CartItem> cartItems= cartItemRepository.findAllByUserProfile_userID(userId);
		for(CartItem item: cartItems) {
			OrderItems orderItem=new OrderItems();
			orderItem.setOrders(createdOrder);
			orderItem.setQuantity(item.getQuantity());
			orderItem.setProducts(item.getProducts());
			int id= orderItemsRepository.save(orderItem).getOrderItemId();
			
			OrderItemDTO tempItem=new OrderItemDTO(id,item.getProducts() , item.getQuantity());
			currentOrderItems.add(tempItem);
					
			cartItemRepository.delete(item);
				
		}
		
		OrderDTO getCreatedOrder= new OrderDTO();
		getCreatedOrder.setOrderId(createdOrder.getOrderId());
		getCreatedOrder.setOrderitems(currentOrderItems);;
		
		
		return getCreatedOrder;
	}
	
	
	
	
	

	public Object orderHistory(int userId) {
		List<OrderDTO> ordersHistoryList= new ArrayList<>();
		
		List<Orders> allOrdersByUserId= ordersRepository.findByUserProfile_userID(userId);
		
		for(Orders i:allOrdersByUserId)
		{
			
			List<OrderItemDTO> orderItemsList= new ArrayList<>();
			
			List<OrderItems> allOrderItemsByOrderId= new ArrayList<>();
			
			allOrderItemsByOrderId= orderItemsRepository.findByOrders(i);
			
			for(OrderItems j: allOrderItemsByOrderId) {
				
				OrderItemDTO tempOrderItemDTOobj= new OrderItemDTO(j.getOrderItemId(),j.getProducts(),j.getQuantity());

				orderItemsList.add(tempOrderItemDTOobj);
			}
			
			OrderDTO tempOrderDTOobj= new OrderDTO(i.getOrderId(),orderItemsList);

			ordersHistoryList.add(tempOrderDTOobj);
			
		}
		
		
		return ordersHistoryList;
	}
}
