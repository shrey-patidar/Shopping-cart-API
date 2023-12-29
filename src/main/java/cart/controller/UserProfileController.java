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
import cart.entity.UserProfile;
import cart.service.UserProfileService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserProfileController {
	
	@Autowired
	private UserProfileService userProfileService;

	@RequestMapping("/getprofile/{userid}")
	public ResponseEntity<?> getProfile(@PathVariable int userid) {
		return new ResponseEntity<>(userProfileService.getProfile(userid),HttpStatus.OK);
	}

	
	@PostMapping("/updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody UserProfile userProfile) {
		userProfileService.updateProfile(userProfile);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	
	@PostMapping("/addProfile")
	public ResponseEntity<?> addProfile(@RequestBody UserProfile userProfile) {
		userProfileService.addProfile(userProfile);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	
}
