package com.acme.services.profile;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acme.commons.entities.profile.User;
import com.acme.dao.profile.IProfileDAO;
import com.acme.dao.profile.ProfileDAOException;

@Component("ProfileImpl")
public class ProfileImpl  implements IProfile {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("profileDAOImpl")
	IProfileDAO  iProfileDao;

	


	public boolean saveUpdateProfile(User user) throws ProfileException {
		
		
		boolean isSaved = false;
		try {
			if(user!=null)
				isSaved = iProfileDao.saveUpdateProfile(user);
		} catch (ProfileDAOException e) {
			throw new ProfileException();
		}
		
		return isSaved;
				
	
	}

	@Override
	public User getUserByID(long userId) throws InvalidProfileException {
		
		User userRetrieved = (User) sessionFactory.openSession().get(User.class,userId);
		
		if (userRetrieved == null) {
			throw new InvalidProfileException(InvalidProfileException.EXCEPTION_NO_USER_FOUND);
		}
		
		return userRetrieved;
	}

	@Override
	public User getUserByName(String userName) throws InvalidProfileException {

		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("userName", userName));
		User userRetrieved = (User) crit.uniqueResult();
		
		if (userRetrieved == null) {
			throw new InvalidProfileException(InvalidProfileException.EXCEPTION_NO_USER_FOUND);
		}
		
		return userRetrieved;
	}

}
