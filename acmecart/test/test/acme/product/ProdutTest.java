package test.acme.product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.commons.entities.product.Product;
import com.acme.commons.entities.product.ProductFields;
import com.acme.commons.entities.product.ProductTypes;
import com.acme.commons.entities.product.ProductView;
import com.acme.commons.entities.supplier.Vendor;
import com.acme.dao.product.IProductDAO;
import com.acme.dao.product.ProductDAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:configs/acme-services-beans.xml" })
public class ProdutTest extends TestCase {

	@Autowired
	@Qualifier("productDAOImpl")
	IProductDAO productServ;

	@Autowired
	SessionFactory sessionFactory;
	
	@Test
	public void testAll() {

		try {

			
			ProductFields bookAttribute  = new ProductFields();
			bookAttribute.setAttributeName("isbn");
			bookAttribute.setAttributeValue("isbn-12345");
			Set<ProductFields> bookSetAttribute = new HashSet<ProductFields>();
			bookSetAttribute.add(bookAttribute)	;
	
			ProductTypes bookType = new ProductTypes();
			bookType.setTypeID(1000);
			bookType.setProductType("Book");
			bookType.setProductAttribute(bookSetAttribute);

			productServ.saveProductType(bookType);
	
			Product bookProd = new Product();
			bookProd.setProductId(1000);
			bookProd.setProductTitle("Harry Potter");
			bookProd.setShortDesc("Harry Potter Part 2");
			bookProd.setType(bookType);
			
			Vendor vendor = new Vendor();
			vendor.setCostPrice(499.99);
			vendor.setSellingPrice(599.99);
			
			vendor.setPriceId(1000);
			vendor.setCostPrice(499.99);
			vendor.setSupplierId(1000);
			vendor.setSupplierName("AMAZON");
			
			Set <Vendor> vendors  = new HashSet() ;
			vendors.add(vendor);
			bookProd.setVendors(vendors);
			
			productServ.saveProductSupplier(bookProd);

			productServ.saveProduct(bookProd);

			long typeID = 1000;
			Session session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Product.class);
			crit.add(Restrictions.eq("productId",typeID ));
			List<Product>  productByCategoryList  = crit.list();
			if(productByCategoryList == null){
				throw new ProductDAOException();
			}
			
            for(Product prods: productByCategoryList){
            	
            	//System.out.println("Title"+prods.getProductTitle());
            }
			

		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	
	@Test
	public void testGEtProductDEtailsFromView() {

		try {

			List<ProductView> products = productServ.getProductDetails(1000);
			for(ProductView productView :products){
				//System.out.println(productView.toString());
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
}
