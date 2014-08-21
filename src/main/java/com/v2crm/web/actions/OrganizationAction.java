package com.v2crm.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.v2crm.domain.Industry;
import com.v2crm.domain.LeadStatus;
import com.v2crm.domain.Organization;
import com.v2crm.domain.OrganizationType;
import com.v2crm.domain.OwnerShip;
import com.v2crm.domain.Rating;
import com.v2crm.domain.RevenueRange;
import com.v2crm.domain.State;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.OrganizationService;
import com.v2crm.util.DataList;
import com.v2crm.util.SpringUtil;

public class OrganizationAction extends ActionSupport implements ServletRequestAware {
	Logger logger = LoggerFactory.getLogger(OrganizationAction.class);
	//private Org orgService;
	
	private OrganizationService organizationService;
	
	private DataList dataList;
	
	HttpServletRequest httpServletRequest;
	
	public String display() 
	{
		organizationService = (OrganizationService)SpringUtil.getSpringUtil().getService("organizationService");
		List<Organization> orgs = organizationService.findAll();
		
	        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
	        if(httpServletRequest != null){
	        	dataList = new DataList(httpServletRequest);
	        	dataList.setList(orgs);
	        }
	        else{
	        	dataList = new DataList();
	        	dataList.setList(orgs);
	        }
	        
	        httpServletRequest.setAttribute( "data", dataList );
	        return SUCCESS;
	}



	public String delete(){
		organizationService = (OrganizationService)SpringUtil.getSpringUtil().getService("organizationService");
		String orgId = httpServletRequest.getParameter("id");
		if(orgId != null){
			
		}
		organizationService.delete(Long.parseLong(orgId));
		List<Organization> orgs = organizationService.findAll();
		
        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
        if(httpServletRequest != null){
        	dataList = new DataList(httpServletRequest);
        	dataList.setList(orgs);
        }
        else{
        	dataList = new DataList();
        	dataList.setList(orgs);
        }
        
        httpServletRequest.setAttribute( "data", dataList );
        return "delete_success";
	}
	
	
	public String edit(){
		organizationService = (OrganizationService)SpringUtil.getSpringUtil().getService("organizationService");
		if(httpServletRequest.getParameter("id") != null){
			Long orgId = Long.parseLong(httpServletRequest.getParameter("id"));
			Organization organization = (Organization) organizationService.find(orgId);
			httpServletRequest.setAttribute("organization", organization);
		}
	    return "edit_success";
	}
	
	public String save(){
		try {
			organizationService = (OrganizationService)SpringUtil.getSpringUtil().getService("organizationService");
			Organization org = (Organization) httpServletRequest.getSession().getAttribute("organization");
			
			org.setOrgName(httpServletRequest.getParameter("orgName"));
			
			org.setCompany(httpServletRequest.getParameter("company"));
			
			org.setPrimaryEmail(httpServletRequest.getParameter("primaryEmail"));
			org.setPrimaryPhone(httpServletRequest.getParameter("primaryPhone"));
			//org.setDesignation(httpServletRequest.getParameter("designation"));
			
			org.setMobile(httpServletRequest.getParameter("mobile"));
			org.setWebsite(httpServletRequest.getParameter("website"));
			org.setFax(httpServletRequest.getParameter("fax"));
			
			if(httpServletRequest.getParameter("noOfEmployers") != null){
				org.setNumOfEmployers(Integer.parseInt(httpServletRequest.getParameter("noOfEmployers")));
			}
			
			org.setRevenueRange(RevenueRange.valueOf(httpServletRequest.getParameter("revenueRange")));
			org.setOwnerShip(OwnerShip.valueOf(httpServletRequest.getParameter("ownerShip")));
			org.setOrganizationType(OrganizationType.valueOf(httpServletRequest.getParameter("organizationType")));
			
			org.setIndustry(Industry.valueOf(httpServletRequest.getParameter("industry")));
			
			//org.setOrgStatus(LeadStatus.valueOf(httpServletRequest.getParameter("orgStatus")));
			
			org.setRating(Rating.valueOf(httpServletRequest.getParameter("rating")));
			
			org.getAddress().setCity(httpServletRequest.getParameter("city"));
			org.getAddress().setStreet(httpServletRequest.getParameter("street"));
			org.getAddress().setBldg(httpServletRequest.getParameter("building"));
			
			org.getAddress().setOfficeNumber(httpServletRequest.getParameter("officeNumber"));
			org.getAddress().setPin(httpServletRequest.getParameter("zip"));
			org.getAddress().setState(State.valueOf(httpServletRequest.getParameter("state")));
			org.getAddress().setCountry(httpServletRequest.getParameter("country"));
			httpServletRequest.setAttribute("org", org);
			if(org.getId() == null){
				organizationService.save(org);
			}
			else{
				organizationService.saveOrUpdate(org);
			}
			
			return "save_success";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "save_failure";
	}

	
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.httpServletRequest = arg0;  
	}

	

}
