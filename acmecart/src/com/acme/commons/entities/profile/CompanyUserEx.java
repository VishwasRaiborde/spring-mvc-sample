package com.acme.commons.entities.profile;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user_company")
@PrimaryKeyJoinColumn(name="user_id")
public class CompanyUserEx extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String USER_TYPE_COMPANY = "COMPANY";
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="vat_no")
	private int vatNo;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getVatNo() {
		return vatNo;
	}

	public void setVatNo(int vatNo) {
		this.vatNo = vatNo;
	}

}
