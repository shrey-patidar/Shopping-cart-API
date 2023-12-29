package cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cart.entity.UserProfile;
import cart.repository.UserProfileRepository;

@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;

	public UserProfile getProfile(int userid) {
		return userProfileRepository.findById(userid);
	}

	public void updateProfile(UserProfile userProfile) {	
		userProfileRepository.save(userProfile);
	}

	public void addProfile(UserProfile userProfile) {
		userProfileRepository.save(userProfile);
		
	}
	
	
}
