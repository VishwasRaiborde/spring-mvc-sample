package com.acme.services.product;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acme.commons.entities.product.Product;
import com.acme.commons.entities.product.ProductTypes;
import com.acme.commons.entities.product.ProductView;
import com.acme.commons.entities.purchaseorder.PurchaseOrderView;
import com.acme.commons.entities.supplier.Vendor;
import com.acme.dao.product.BasketDataException;
import com.acme.dao.product.IProductDAO;
import com.acme.dao.product.ProductDAOException;

@Component(value="ProductImpl")
public class ProductImpl<T> implements IProduct {


	@Autowired
	@Qualifier("productDAOImpl")
	IProductDAO iProductDao;

	@Override
	public Product saveProduct(Product product) throws ProductException {
		try {
			
			iProductDao.saveProduct(product);
			
		} catch (ProductDAOException e) {

		}
		return product;
	}

	public ProductTypes saveProductType(ProductTypes productTypes)throws ProductException {
		try {
		
			productTypes = iProductDao.saveProductType(productTypes);
			
		} catch (ProductDAOException e) {

		}
		return productTypes;
	}
	
	

	public List<Product> getProductsByCategory(long categoryId)	throws ProductException {

		List<Product> productByCategoryList = null;
		try {
		
			productByCategoryList = iProductDao.getProductsByCategory(categoryId);

		} catch (ProductDAOException e) {
	
		}
		return productByCategoryList;
	}


	@Override
	public List<PurchaseOrderView> getBasketByUserId(long userId)
			throws BasketException {
		List<PurchaseOrderView> purchaseOrderViews = null ;
		try {
			
			purchaseOrderViews  = iProductDao.getBasketByUserId(userId);
			
		} catch (BasketDataException e) {

			throw new BasketException(e.getMessage());
		}
		return purchaseOrderViews;
	}

	@Override
	public Set<Vendor> saveProductSupplier(Product product)
			throws ProductException {
		 Set<Vendor> vendor = null ;
		try {
			
			vendor =  iProductDao.saveProductSupplier(product);
			
		} catch (ProductDAOException e) {
			throw new ProductException(e.getMessage());
		}
		return vendor;
	}

	@Override
	public List<ProductView> getProductDetails(long productid)
			throws ProductException {
		
		 List<ProductView> productDetails = null;
		
		 try {
			
			productDetails =  iProductDao.getProductDetails(productid);
			
		} catch (ProductDAOException e) {
			throw new ProductException(e.getMessage());
		}
		return productDetails ;
		
	}

	@Override
	public void removeProductFromCart(long orderID)
			throws ProductException {
		try {
			
			iProductDao.removeProductFromCart(orderID);
			
		} catch (ProductDAOException e) {
			throw new ProductException(e.getMessage());
		}
		
	}

}
