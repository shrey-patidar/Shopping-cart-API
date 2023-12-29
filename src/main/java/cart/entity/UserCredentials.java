package cart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

@Entity
public class UserCredentials {

	@Id
	private String eMail;
	
	@NonNull
	private String password;
	
	@OneToOne
	private UserProfile userprofile;

	public UserCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCredentials(String eMail, String password, UserProfile userprofile) {
		super();
		this.eMail = eMail;
		this.password = password;
		this.userprofile = userprofile;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(UserProfile userprofile) {
		this.userprofile = userprofile;
	}
	
	
	
}
