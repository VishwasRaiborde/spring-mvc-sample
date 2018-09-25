package com.acme.services.profile;

import com.acme.commons.entities.profile.User;

public interface IProfile {

	public boolean saveUpdateProfile(User user) throws ProfileException;
	
	public User getUserByID(long userId) throws InvalidProfileException;
	
	public User getUserByName(String userName) throws InvalidProfileException;
	

}
