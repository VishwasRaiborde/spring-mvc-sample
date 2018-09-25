package com.acme.services.product;

import java.util.List;
import java.util.Set;

import com.acme.commons.entities.product.Product;
import com.acme.commons.entities.product.ProductTypes;
import com.acme.commons.entities.product.ProductView;
import com.acme.commons.entities.purchaseorder.PurchaseOrderView;
import com.acme.commons.entities.supplier.Vendor;



public interface IProduct{
	
	public ProductTypes saveProductType(ProductTypes productTypes) throws ProductException;

	public Product saveProduct(Product product) throws ProductException;
	
	public Set<Vendor> saveProductSupplier(Product product) throws ProductException;
	

	public List<Product> getProductsByCategory(long categoryId) throws ProductException ;

	public List<PurchaseOrderView> getBasketByUserId(long userId) throws BasketException;
	
	public List<ProductView> getProductDetails(long productid) throws ProductException;
	
	public void removeProductFromCart(long orderID) throws ProductException;

}



