package com.acme.commons.entities.supplier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.acme.commons.entities.price.Price;
import com.acme.commons.entities.product.Product;

@Entity
@Table(name="Supplier_tbl")
@PrimaryKeyJoinColumn(name="PRICE_ID")
public class Vendor extends Price implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="SUPPLIER_ID")
   	private  long id;
    
    @Column(name="supplier_name")
	private String supplierName;
    
    @ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
    
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public long getSupplierId() {
		return id;
	}
	public void setSupplierId(long supplierId) {
		this.id = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	

	
}
