package cart.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cart.entity.CartItem;
import cart.repository.CartItemRepository;
import cart.repository.ProductRepository;
import cart.repository.UserProfileRepository;
import cart.requestObjects.QuantityObject;
import cart.responseObjects.GetCart;
import cart.responseObjects.GetCartItem;

@Service
public class CartService {
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	

	public CartItem addToCart(int userId, int productId) {
		
		CartItem temp=cartItemRepository.findByUserProfile_userIDAndProducts_productid(userId, productId);
		
		if(temp != null) {
			temp.setQuantity((temp.getQuantity())+1);
			cartItemRepository.save(temp);
			return cartItemRepository.findByUserProfile_userIDAndProducts_productid(userId, productId);
		}
		
		else {
			CartItem item = new CartItem(userProfileRepository.findById(userId),productRepository.findById(productId),1);
			cartItemRepository.save(item);
			
			return cartItemRepository.findByUserProfile_userIDAndProducts_productid(userId, productId);		
		}
		
	}



	public String removeFromCart(int userId, int productId) {
		
		cartItemRepository.deleteById(cartItemRepository.findByUserProfile_userIDAndProducts_productid(userId, productId)
										.getCartItemId());
		return productRepository.findById(productId).getName() + " removed from cart";
	}



	
	public GetCartItem getCartItem(int userId, int cartitemId) {
		
		CartItem item= cartItemRepository.findById(cartitemId);
		GetCartItem itemDTO= new GetCartItem();
		itemDTO.setCartItemId(item.getCartItemId());
		itemDTO.setProduct(item.getProducts());
		itemDTO.setQuantity(item.getQuantity());
		
		return itemDTO;
	}


	
	

	public CartItem changeQuantity(int userId, int productId, QuantityObject quantity) {

		CartItem item= cartItemRepository.findByUserProfile_userIDAndProducts_productid(userId, productId);
		item.setQuantity(quantity.getQuantity());
		cartItemRepository.save(item);
		return cartItemRepository.findByUserProfile_userIDAndProducts_productid(userId, productId);
	}

	
	



	
	public GetCart getCart(int userId) {
		
		GetCart cart= new GetCart();
		cart.setUserId(userId);
		
		int total=0;
		List<GetCartItem> itemList= new ArrayList<>();
		for(CartItem item: cartItemRepository.findAllByUserProfile_userID(userId)) {
			GetCartItem temp= new GetCartItem(item.getCartItemId(),item.getProducts(), item.getQuantity());
			itemList.add(temp);
			total += item.getProducts().getPrice()*item.getQuantity();
		}
		
		cart.setCartItems(itemList);
		cart.setTotalPrice(total);
		
		
		return cart;
	}

	
	
	
}
