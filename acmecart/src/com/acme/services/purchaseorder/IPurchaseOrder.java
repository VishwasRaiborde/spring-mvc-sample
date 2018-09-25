package com.acme.services.purchaseorder;

import com.acme.commons.entities.purchaseorder.PurchaseOrder;


public interface IPurchaseOrder  {

	
	public PurchaseOrder saveOrUpdatePurchaseOrder(PurchaseOrder purchaseOrder) throws CartException;
	
}