	package cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cart.entity.CartItem;
import cart.entity.Products;
import cart.entity.UserProfile;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	CartItem findByUserProfile_userIDAndProducts_productid(int userId,int productsId);
	CartItem findByUserProfileAndProducts(UserProfile user, Products product);
	CartItem findById(int cartItemId);
	List<CartItem> findAllByUserProfile(UserProfile user);
	List<CartItem> findAllByUserProfile_userID(int userId);
}
