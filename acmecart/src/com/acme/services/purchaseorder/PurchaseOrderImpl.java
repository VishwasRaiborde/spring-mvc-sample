package com.acme.services.purchaseorder;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acme.commons.entities.purchaseorder.PurchaseOrder;
import com.acme.dao.order.CartDataException;
import com.acme.dao.order.IPurchaseOrderDAO;



@Component(value="PurchaseOrderImpl")
public class PurchaseOrderImpl implements IPurchaseOrder{

	@Autowired
	@Qualifier("PurchaseOrderDAOImpl")
	IPurchaseOrderDAO  iPurchaseOrderDao;

	
	@Override
	public PurchaseOrder saveOrUpdatePurchaseOrder(PurchaseOrder purchaseOrder) throws CartException{
		
		PurchaseOrder purchaseOrderRetrieved = null ;
		try {
			 
			purchaseOrderRetrieved  =  iPurchaseOrderDao.saveOrUpdatePurchaseOrder(purchaseOrder);
			
		} catch (CartDataException e) {
			
			throw new  CartException(CartException.MESSAGE);
		}
		
		return purchaseOrderRetrieved ;
	}
	
	
}