package com.v2crm.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Oppurtunity extends Base{

private String oppurtunityName;

@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="organization_id",insertable=true, updatable=true)
private Organization organization;

private Long amount;

@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="contact_id",insertable=true, updatable=true)
private Contact contact;

private Date expectedClosedDate;

private String expClosureDate;



@Enumerated(EnumType.STRING)
private SalesStage salesStage = SalesStage.Proposal;

@Enumerated(EnumType.STRING)
private LeadSource leadSource = LeadSource.CustomerInquiryByPhone;

@Enumerated(EnumType.STRING)
private OppurtunityType oppurtunityType = OppurtunityType.NewBusiness;

@Enumerated(EnumType.STRING)
private OppurtunityStrategy oppurtunityStrategy = OppurtunityStrategy.CanLeadToMore;

private Integer probability;

private String primaryEmail;

@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="campaign_id",insertable=true, updatable=true)
private Campaign campaign;

public String getOppurtunityName() {
	return oppurtunityName;
}

public void setOppurtunityName(String oppurtunityName) {
	this.oppurtunityName = oppurtunityName;
}

public Organization getOrganization() {
	return organization;
}

public void setOrganization(Organization organization) {
	this.organization = organization;
}

public Long getAmount() {
	return amount;
}

public void setAmount(Long amount) {
	this.amount = amount;
}

public Contact getContact() {
	return contact;
}

public void setContact(Contact contact) {
	this.contact = contact;
}

public Date getExpectedClosedDate() {
	return expectedClosedDate;
}

public void setExpectedClosedDate(Date expectedClosedDate) {
	this.expectedClosedDate = expectedClosedDate;
}

public SalesStage getSalesStage() {
	return salesStage;
}

public void setSalesStage(SalesStage salesStage) {
	this.salesStage = salesStage;
}

public LeadSource getLeadSource() {
	return leadSource;
}

public void setLeadSource(LeadSource leadSource) {
	this.leadSource = leadSource;
}

public OppurtunityType getOppurtunityType() {
	return oppurtunityType;
}

public void setOppurtunityType(OppurtunityType oppurtunityType) {
	this.oppurtunityType = oppurtunityType;
}

public OppurtunityStrategy getOppurtunityStrategy() {
	return oppurtunityStrategy;
}

public void setOppurtunityStrategy(OppurtunityStrategy oppurtunityStrategy) {
	this.oppurtunityStrategy = oppurtunityStrategy;
}

public Integer getProbability() {
	return probability;
}

public void setProbability(Integer probability) {
	this.probability = probability;
}

public String getPrimaryEmail() {
	return primaryEmail;
}

public void setPrimaryEmail(String primaryEmail) {
	this.primaryEmail = primaryEmail;
}

public Campaign getCampaign() {
	return campaign;
}

public void setCampaign(Campaign campaign) {
	this.campaign = campaign;
}



public String getExpClosureDate() {
	DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	if(getExpectedClosedDate() != null ){
		String formattedDate = formatter.format(getExpectedClosedDate());
		return formattedDate;
	}
	return "";
}

}
