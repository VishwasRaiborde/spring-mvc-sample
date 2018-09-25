package com.acme.dao.profile;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.commons.entities.profile.User;

@Component("profileDAOImpl")
public class ProfileDAOImpl  implements		IProfileDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public boolean saveUpdateProfile(User user) throws ProfileDAOException {
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		try {
			session.saveOrUpdate(user);
			trx.commit();
			return true;
		} catch (Exception e) {
			trx.rollback();
			throw new ProfileDAOException(e);
		}
	}

	@Override
	public User getUserByID(long userId) throws InvalidProfileException {
		User userRetrieved = (User) sessionFactory.getCurrentSession().get(User.class,
				userId);
		if (userRetrieved == null) {
			throw new InvalidProfileException(
					InvalidProfileException.EXCEPTION_NO_USER_FOUND);
		}
		return userRetrieved;
	}

	@Override
	public User getUserByName(String userName) throws InvalidProfileException {

		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("userName", userName));
		User userRetrieved = (User) crit.uniqueResult();
		if (userRetrieved == null) {
			throw new InvalidProfileException(
					InvalidProfileException.EXCEPTION_NO_USER_FOUND);
		}
		return userRetrieved;
	}

}
