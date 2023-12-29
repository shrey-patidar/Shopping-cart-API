package cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cart.entity.UserCredentials;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, String > {
	
}
