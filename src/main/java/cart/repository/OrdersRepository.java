package cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cart.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
		List<Orders> findByUserProfile_userID(int userId);
}
