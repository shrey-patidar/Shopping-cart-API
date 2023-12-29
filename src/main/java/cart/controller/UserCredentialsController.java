package cart.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cart.entity.UserCredentials;
import cart.requestObjects.SignUpDetails;
import cart.service.UserCredentialsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserCredentialsController {
	@Autowired
	private UserCredentialsService userCredentialsService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserCredentials userCredentials){
		return userCredentialsService.login(userCredentials);
	}
	

	
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody SignUpDetails signUpDetails){
		return userCredentialsService.signUp(signUpDetails);
	}
	
	
}
