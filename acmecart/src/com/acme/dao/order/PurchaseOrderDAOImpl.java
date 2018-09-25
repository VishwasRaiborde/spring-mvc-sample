package com.acme.dao.order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.commons.entities.purchaseorder.PurchaseOrder;

@Component(value = "PurchaseOrderDAOImpl")
public class PurchaseOrderDAOImpl implements IPurchaseOrderDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public PurchaseOrder saveOrUpdatePurchaseOrder(PurchaseOrder purchaseOrder) throws CartDataException{
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.saveOrUpdate(purchaseOrder);
		txn.commit();
		return purchaseOrder;
	}

}