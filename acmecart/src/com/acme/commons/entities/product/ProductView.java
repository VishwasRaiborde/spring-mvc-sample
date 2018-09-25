package com.acme.commons.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_details_view")
public class ProductView implements Serializable {
	

	@Id
	@Column(name="PRODUCT_ID")
	private long    productId;
	
	@Column(name="SUPPLIER_ID")
	private long    supplierID;
	
	@Column(name="PRODUCT_TITLE")
	private String  productTitle;
	
	@Column(name="PRODUCT_SHORT_DESC")
	private String  shortDesc;
	
	@Column(name="PRODUCT_TYPE_NAME")
	private String type ;
	
	@Column(name="SUPPLIER_NAME")
	private String supplierName ;
	
	@Column(name="COST_PRICE")
	private double costPrice;
	
	@Column(name="SELLING_PRICE")
	private double sellingPrice;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public long getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(long supplierID) {
		this.supplierID = supplierID;
	}
	
	@Override
	public String toString() {
		return "ProductView [productId=" + productId + ", productTitle="
				+ productTitle + ", shortDesc=" + shortDesc + ", type=" + type
				+ ", supplierName=" + supplierName + ", costPrice=" + costPrice
				+ ", sellingPrice=" + sellingPrice + "]";
	}
	
	
}
