package test.acme.supplier;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.commons.entities.supplier.Vendor;
import com.acme.dao.supplier.SupplierDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:configs/acme-services-beans.xml" })

public class SupplierTest extends TestCase {
	@Autowired
	SupplierDAOImpl<Vendor> supplierDAO;
	
	@Test
	public void testsaveOrUpdateSupplier(){
		
	Vendor supplier = new Vendor();
    //supplier.setSupplierId(1111);
	supplier.setSupplierName("Amazon");
	
	supplierDAO.saveOrUpdateSupplier(supplier);
	
		
	}
	

}
