package com.acme.dao.supplier;

import com.acme.commons.entities.supplier.Vendor;


public interface ISupplierDAO {

	public Vendor saveOrUpdateSupplier(Vendor supplier);

}