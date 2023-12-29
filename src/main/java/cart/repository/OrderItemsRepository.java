package cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cart.entity.OrderItems;
import cart.entity.Orders;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {
	List<OrderItems> findByOrders(Orders order);
}
