package com.acme.commons.entities.product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="PRODUCT_TYPE_TBL")
@Entity
public class ProductTypes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="PRODUCT_TYPE_ID")
	@JoinColumn(name="PRODUCT_TYPE_ID")
	long typeID ;
	
	@Column(name="PRODUCT_TYPE_NAME")
	
	String  productType ;
	
	
	@OneToMany(mappedBy="type")
	private Set<Product> products = new HashSet<Product>(0);
	
	@OneToMany(mappedBy="type")
	private Set<ProductFields> productAttribute = new HashSet<ProductFields>(0);
	
	public long getTypeID() {
		return typeID;
	}
	public void setTypeID(long typeID) {
		this.typeID = typeID;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Set<ProductFields> getProductAttribute() {
		return productAttribute;
	}
	public void setProductAttribute(Set<ProductFields> productAttribute) {
		this.productAttribute = productAttribute;
	}
	
	

	
	
	
	

}
