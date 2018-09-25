package com.acme.dao.profile;

import com.acme.commons.entities.profile.User;

public interface IProfileDAO {

	public boolean saveUpdateProfile(User user) throws ProfileDAOException;
	
	public User getUserByID(long userId) throws InvalidProfileException;
	
	public User getUserByName(String userName) throws InvalidProfileException;
	

}
