package com.acme.dao.supplier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.acme.commons.entities.supplier.Vendor;

public class SupplierDAOImpl<T> implements ISupplierDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Vendor saveOrUpdateSupplier(Vendor supplier) {

		Session session = sessionFactory.getCurrentSession();
		Transaction txn = session.beginTransaction();
		session.saveOrUpdate(supplier);
		txn.commit();
		return supplier;
	}

}