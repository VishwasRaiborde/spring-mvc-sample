package com.acme.dao.product;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.commons.entities.product.Product;
import com.acme.commons.entities.product.ProductFields;
import com.acme.commons.entities.product.ProductTypes;
import com.acme.commons.entities.product.ProductView;
import com.acme.commons.entities.purchaseorder.PurchaseOrder;
import com.acme.commons.entities.purchaseorder.PurchaseOrderView;
import com.acme.commons.entities.supplier.Vendor;
@Component(value="productDAOImpl")
public class ProductDAOImpl implements IProductDAO  {


	@Autowired
	SessionFactory sessionFactory;
		
	
	public ProductTypes saveProductType(ProductTypes productTypes) throws ProductDAOException{
	
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		Set<ProductFields> productFields  = productTypes.getProductAttribute();
		session.saveOrUpdate(productTypes);
		
		for(ProductFields productField : productFields){
			productField.setAttributeOfproduct(productTypes);
			session.saveOrUpdate(productField);
		}
		trx.commit();
		return productTypes;
	}
	
	public Set<ProductFields> saveProductFields(ProductTypes productTypes) throws ProductDAOException{
		
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		Set<ProductFields> productFields  = productTypes.getProductAttribute();
		session.saveOrUpdate(productTypes);
		
		for(ProductFields productField : productFields){
			productField.setAttributeOfproduct(productTypes);
			session.saveOrUpdate(productField);
		}
		trx.commit();
		return productFields;
	}
	
	public Set<Vendor> saveProductSupplier(Product product) throws ProductDAOException{
		
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		Set<Vendor> vendors  = product.getVendors();
		session.saveOrUpdate(product);
		
		for(Vendor vendor : vendors){
			vendor.setProduct(product);
			vendor.setProduct(product);
			session.saveOrUpdate(vendor);
		}
		
		trx.commit();
		session.close();
		return vendors;
	}
	
	@Override
	public Product saveProduct(Product product) throws ProductDAOException {
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.saveOrUpdate(product);
		trx.commit();
		session.close();
		return product;
	}
	

	public List<Product> getProductsByCategory(long type) throws ProductDAOException {
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.eq("type.typeID",type ));
		List<Product>  productByCategoryList  = crit.list();
		
		if(productByCategoryList == null){
			throw new ProductDAOException();
		}
		
		return productByCategoryList;
	}


	
	public List<PurchaseOrderView> getBasketByUserId(long userID)
			throws BasketDataException {
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(PurchaseOrderView.class);
		crit.add(Restrictions.eq("userID",userID ));
		List<PurchaseOrderView>  carts  = crit.list();
		
		if(carts == null){
			throw new BasketDataException(BasketDataException.NO_CART_ITEMS_FOUND);
		}
		
		return carts;
	}
	
	
	public List<ProductView> getProductDetails(long productid) throws ProductDAOException{
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(ProductView.class);
		crit.add(Restrictions.eq("productId",productid ));
		List<ProductView>  product  = (List<ProductView>) crit.list();
		
		if(product == null){
			throw new ProductDAOException(ProductDAOException.EXCEPTION_NO_PRODUCT_FOUND);
		}
		
		return product;
	}

	@Override
	public void removeProductFromCart(long orderID)
			throws ProductDAOException {
		Session session;
		Transaction trx;
		try {
			session = sessionFactory.openSession();
			trx = session.beginTransaction();
			PurchaseOrder order = new PurchaseOrder();
			order.setOrderId(orderID);
			session.delete(order);
			trx.commit();
			session.close();
		} catch (Exception e) {
			
			throw new ProductDAOException();
		}
		
	}



}

