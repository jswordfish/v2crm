package com.v2crm.web.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.v2crm.domain.Lead;
import com.v2crm.services.LeadService;
import com.v2crm.util.SpringUtil;

public class EditLeadAction extends ActionSupport implements ServletRequestAware{
	Logger logger = LoggerFactory.getLogger(LeadAction.class);
	private LeadService leadService;
	
	private Lead lead;
	
	HttpServletRequest httpServletRequest;
	


	public String editLead(){
		leadService = (LeadService)SpringUtil.getSpringUtil().getService("leadService");
		Long leadId = Long.parseLong(httpServletRequest.getParameter("id"));
		lead = (Lead) leadService.find(leadId);
		httpServletRequest.setAttribute("lead", lead);
	    return "edit_success";
	}

	
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.httpServletRequest = arg0;  
	}

	
}
