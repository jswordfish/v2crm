package com.v2crm.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
@Entity
public class Lead extends Base{
	@Transient
	private static final long serialVersionUID = 1L;

	String firstName;
    
    String lastName;
    
    String company;
    
    String primaryEmail;
    
    String primaryPhone;
    
    String designation;
    
    String mobile;
    
    String website;
    
    String fax;
    
    int numOfEmployers;

    
  

    @Enumerated(EnumType.STRING)
    Industry industry;
    
    @Enumerated(EnumType.STRING)
    LeadSource leadSource;
    
    @Enumerated(EnumType.STRING)
    LeadStatus leadStatus;
    
    @Enumerated(EnumType.STRING)
    Rating rating;
	
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="address_id",insertable=true, updatable=true)
    Address address;
    
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="organization_id",insertable=true, updatable=true)
    Organization organization;
	

	

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getPrimaryEmail() {
		return primaryEmail;
	}


	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}


	public String getPrimaryPhone() {
		return primaryPhone;
	}


	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public int getNumOfEmployers() {
		return numOfEmployers;
	}


	public void setNumOfEmployers(int numOfEmployers) {
		this.numOfEmployers = numOfEmployers;
	}


	public Industry getIndustry() {
		return industry;
	}


	public void setIndustry(Industry industry) {
		this.industry = industry;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public LeadSource getLeadSource() {
		return leadSource;
	}


	public void setLeadSource(LeadSource leadSource) {
		this.leadSource = leadSource;
	}


	public LeadStatus getLeadStatus() {
		return leadStatus;
	}


	public void setLeadStatus(LeadStatus leadStatus) {
		this.leadStatus = leadStatus;
	}


	public Rating getRating() {
		return rating;
	}


	public void setRating(Rating rating) {
		this.rating = rating;
	}


	public Organization getOrganization() {
		return organization;
	}


	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
    
    

}
