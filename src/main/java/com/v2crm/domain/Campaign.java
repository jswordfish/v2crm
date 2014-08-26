package com.v2crm.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Campaign extends Base{

	private String ownedBy = "";
	
	private String campaignName = "";
	
	private Date startDate;
	
	private String sDate;
	
	private String eDate;
	
	private Date endDate;
	
	private Long estimatedCost;
	
	private Long actualCost ;
	
	private Long expectedRevenue;
	
	private Long actualRevenue;
	
	private CampaignType campaignType = CampaignType.Others;
	
	private CampaignStatus campaignStatus = CampaignStatus.Draft;
	
	private CampaignResponseType campaignResponseType = CampaignResponseType.NotApplicable;
	
	private Integer expectedResponseCount;
	
	private Integer actualResponseCount;

	public String getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(Long estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public Long getActualCost() {
		return actualCost;
	}

	public void setActualCost(Long actualCost) {
		this.actualCost = actualCost;
	}

	public Long getExpectedRevenue() {
		return expectedRevenue;
	}

	public void setExpectedRevenue(Long expectedRevenue) {
		this.expectedRevenue = expectedRevenue;
	}

	public Long getActualRevenue() {
		return actualRevenue;
	}

	public void setActualRevenue(Long actualRevenue) {
		this.actualRevenue = actualRevenue;
	}

	public CampaignType getCampaignType() {
		return campaignType;
	}

	public void setCampaignType(CampaignType campaignType) {
		this.campaignType = campaignType;
	}

	public CampaignStatus getCampaignStatus() {
		return campaignStatus;
	}

	public void setCampaignStatus(CampaignStatus campaignStatus) {
		this.campaignStatus = campaignStatus;
	}

	public CampaignResponseType getCampaignResponseType() {
		return campaignResponseType;
	}

	public void setCampaignResponseType(CampaignResponseType campaignResponseType) {
		this.campaignResponseType = campaignResponseType;
	}

	public Integer getExpectedResponseCount() {
		return expectedResponseCount;
	}

	public void setExpectedResponseCount(Integer expectedResponseCount) {
		this.expectedResponseCount = expectedResponseCount;
	}

	public Integer getActualResponseCount() {
		return actualResponseCount;
	}

	public void setActualResponseCount(Integer actualResponseCount) {
		this.actualResponseCount = actualResponseCount;
	}

	public String getsDate() {
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		if(getStartDate() != null ){
			String formattedDate = formatter.format(getStartDate());
			return formattedDate;
		}
		return "";
	}

	public String geteDate() {
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		if(getEndDate() != null ){
			String formattedDate = formatter.format(getEndDate());
			return formattedDate;
		}
		return "";
	}
	
	
}
