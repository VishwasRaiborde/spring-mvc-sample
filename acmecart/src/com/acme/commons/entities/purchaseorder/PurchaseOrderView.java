package com.acme.commons.entities.purchaseorder;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_CART_VIEW")
public class PurchaseOrderView {
	
	@Id
	@Column(name="ORDER_ID")
	private long orderId;
	
	@Column(name="PRODUCT_ID")
	private long productId;
	
	@Column(name="QUANTITY")
	private  Integer quantity;
	
	@Column(name="SUPPLIER_ID")
	private long  supplierId;
	
	@Column(name="USER_ID")
	private long  userID;
	
	
	@Column(name="TRANSACTION_TIME")
	private Date transactionTime;
	
	@Column(name="PRODUCT_TITLE")
	private String productTitle;
	
	@Column(name="SUPPLIER_NAME")
	private String supplierName;
	
	@Column(name="SELLING_PRICE")
	private double price ;
	
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		
		if(quantity == null){
			quantity = 1 ;
		}
		
		this.quantity = quantity;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
}
