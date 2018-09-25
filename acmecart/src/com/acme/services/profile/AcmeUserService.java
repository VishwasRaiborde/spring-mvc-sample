package com.acme.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.acme.commons.entities.profile.User;

@Component("acmeUserService")
public class AcmeUserService implements UserDetailsService{

	@Autowired
	@Qualifier("ProfileImpl")
	IProfile profile ;
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = null ;
		
		try {
			
			 user = profile.getUserByName(userName);
			 // make dicisions as per the matrix if there is need
			 user.setEnabled(true);
			 user.setAccountNonExpired(true);
			 user.setCredentialsNonExpired(true);
			 user.setAccountNonLocked(true);
			 
		} catch (InvalidProfileException e) {
			
			user.setEnabled(false);
			// this can be used to log the attemp failure and lock the account
			user.setAccountNonLocked(false);
			
		}
		return user;
	}

}
