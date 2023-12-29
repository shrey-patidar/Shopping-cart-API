package cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cart.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>{
		UserProfile findById(int userId);
	
}
