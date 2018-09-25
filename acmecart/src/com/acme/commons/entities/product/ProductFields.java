package com.acme.commons.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * one product can have various attibutes 
 *  
 * */

@Entity
@Table(name="PRODUCT_FIELDS_TBL")
public class ProductFields implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ATTRIBUTE_ID")
	private long attributeId;
	
	@Column(name="ATTRIBUTE_NAME")
	private String attributeName;

	@Column(name="ATTRIBUTE_ID_VALUE")
	private String attributeValue;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_TYPE_ID")
	private ProductTypes type;

	
	public ProductTypes getAttributeOfproduct() {
		return type;
	}
	public void setAttributeOfproduct(ProductTypes type) {
		this.type = type;
	}
	
	public long getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(long attributeId) {
		this.attributeId = attributeId;
	}
	
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	

}
