package com.acme.dao.product;

import java.util.List;
import java.util.Set;
import com.acme.commons.entities.product.Product;
import com.acme.commons.entities.product.ProductFields;
import com.acme.commons.entities.product.ProductTypes;
import com.acme.commons.entities.product.ProductView;
import com.acme.commons.entities.purchaseorder.PurchaseOrderView;
import com.acme.commons.entities.supplier.Vendor;

public interface IProductDAO {
	
	
	public ProductTypes saveProductType(ProductTypes productTypes) throws ProductDAOException;

	public Product saveProduct(Product product) throws ProductDAOException;
	
	public Set<ProductFields> saveProductFields(ProductTypes productTypes) throws ProductDAOException;
	
	public Set<Vendor> saveProductSupplier(Product product) throws ProductDAOException;
	
	
	
	public List<Product> getProductsByCategory(long categoryId) throws ProductDAOException ;

	public List<PurchaseOrderView> getBasketByUserId(long userId) throws BasketDataException;
	
	public List<ProductView> getProductDetails(long productid) throws ProductDAOException;
	
	public void removeProductFromCart(long orderID) throws ProductDAOException;
	

}



