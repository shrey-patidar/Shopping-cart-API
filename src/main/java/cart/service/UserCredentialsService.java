package cart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cart.entity.Address;
import cart.entity.UserCredentials;
import cart.entity.UserProfile;
import cart.repository.UserCredentialsRepository;
import cart.repository.UserProfileRepository;
import cart.requestObjects.SignUpDetails;

@Service
public class UserCredentialsService {
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;


	public ResponseEntity<Object> login(UserCredentials userCredentials) {
		Optional<UserCredentials> dbuser = userCredentialsRepository.findById(userCredentials.geteMail());	
		if(dbuser.isPresent()) { 
			UserCredentials temp= dbuser.get();
		
		if(temp.getPassword().equals(userCredentials.getPassword()) ) {
			return new ResponseEntity<Object>(temp.getUserprofile().getUserID(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		}
		else{
			return new ResponseEntity<>(HttpStatus.SEE_OTHER);
			}
		
		}


	
	
	
	public ResponseEntity<Integer> signUp(SignUpDetails signUpDetails) {
		if(userCredentialsRepository.existsById(signUpDetails.getEmail())) {
			return new ResponseEntity<Integer>(userCredentialsRepository.findById(signUpDetails.getEmail()).get().getUserprofile().getUserID(), HttpStatus.SEE_OTHER);
		}
		else {
		
		Address address=new Address("n/a", "n/a", "n/a ", 0);	
			
			
		UserProfile newUserDetails= new UserProfile();	
		newUserDetails.setName(signUpDetails.getName());
		newUserDetails.setEmail(signUpDetails.getEmail());
		newUserDetails.setAddress(address);
	
		UserCredentials newUser= new UserCredentials();
		newUser.seteMail(signUpDetails.getEmail());
		newUser.setPassword(signUpDetails.getPassword());
		
		UserProfile temp= userProfileRepository.save(newUserDetails);
		newUser.setUserprofile(temp);
		
		UserCredentials temp2=userCredentialsRepository.save(newUser);
		
		
		return new ResponseEntity<Integer>(temp2.getUserprofile().getUserID(), HttpStatus.OK);
		}
	}
	
	
}
	
