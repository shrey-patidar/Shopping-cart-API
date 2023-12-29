package cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cart.service.OrderService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order/{userId}/createOrder")
	public ResponseEntity<?> createOrder(@PathVariable int userId){
		return new ResponseEntity<>(orderService.createOrder(userId), HttpStatus.OK) ;
	}
	
	
	@RequestMapping("/order/{userId}/getOrders")
	public ResponseEntity<?> orderHistory(@PathVariable int userId){
		return new ResponseEntity<>(orderService.orderHistory(userId), HttpStatus.OK);
	}
	
	
	
}
