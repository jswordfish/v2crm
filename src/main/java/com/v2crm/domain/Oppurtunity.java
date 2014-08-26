package com.v2crm.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Oppurtunity extends Base{

private String oppurtunityName;

private Organization organization;

private Long amount;

private Contact contact;

private Date expectedClosedDate;

private String eCDate;

private SalesStage salesStage;

private LeadSource leadSource;

private OppurtunityType oppurtunityType;

private OppurtunityStrategy oppurtunityStrategy;

private Integer probability;

private String primaryEmail;

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

public String geteCDate() {
	DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	if(getExpectedClosedDate() != null ){
		String formattedDate = formatter.format(getExpectedClosedDate());
		return formattedDate;
	}
	return "";
}



}
