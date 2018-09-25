package com.acme.commons.entities.product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.acme.commons.entities.supplier.Vendor;

@Entity
@Table(name="PRODUCT_TBL")
public class Product implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRODUCT_ID")
	private long    productId;
	
	@Column(name="PRODUCT_TITLE")
	private String  productTitle;
	
	@Column(name="PRODUCT_SHORT_DESC")
	private String  shortDesc;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_TYPE_ID")
	ProductTypes type ;
	
	@OneToMany(mappedBy="product")
	private Set<Vendor> vendors = new HashSet<Vendor>(0);
	
	
	
	public ProductTypes getType() {
		return type;
	}
	public void setType(ProductTypes type) {
		this.type = type;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	
	
	public Set<Vendor> getVendors() {
		return vendors;
	}
	public void setVendors(Set<Vendor> vendors) {
		this.vendors = vendors;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productTitle="
				+ productTitle + ", shortDesc=" + shortDesc + ", type=" + type
				+ "]";
	}
	
	
}
