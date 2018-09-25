package com.acme.dao.order;

import com.acme.commons.entities.purchaseorder.PurchaseOrder;

public interface IPurchaseOrderDAO  {
	
	public PurchaseOrder saveOrUpdatePurchaseOrder(PurchaseOrder purchaseOrder) throws CartDataException;

	
}