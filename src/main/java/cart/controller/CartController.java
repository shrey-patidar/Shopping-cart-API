package cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cart.requestObjects.QuantityObject;
import cart.service.CartService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping("/cart/{userId}/add/{productId}")
	public ResponseEntity<?> addToCart(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
		return new ResponseEntity<>(cartService.addToCart(userId,productId),HttpStatus.OK) ;
	}
	
	
	@RequestMapping("/cart/{userId}/remove/{productId}")
	public ResponseEntity<?> removeFromCart(@PathVariable("userId") int userId, @PathVariable("productId") int productId){
		return new ResponseEntity<>(cartService.removeFromCart(userId,productId),HttpStatus.OK);
	}
	
	
	@RequestMapping("/cart/{userId}/getCartItem/{cartitemId}")
	public ResponseEntity<?> getCartItem(@PathVariable("userId") int userId, @PathVariable("cartitemId") int cartitemId){
		return new ResponseEntity<>(cartService.getCartItem(userId,cartitemId),HttpStatus.OK);
	}
	
	
	@PostMapping("/cart/{userId}/changeQuantity/{productId}")
	public ResponseEntity<?> changeQuantity(@PathVariable int userId, @PathVariable int productId, @RequestBody QuantityObject quantity){
		return new ResponseEntity<>(cartService.changeQuantity(userId,productId,quantity),HttpStatus.OK);
	}
	
	
	@RequestMapping("/cart/{userId}/getCart")
	public ResponseEntity<?> getCart(@PathVariable int userId){
		return new ResponseEntity<>(cartService.getCart(userId), HttpStatus.OK);
	}
	
	
	
}
