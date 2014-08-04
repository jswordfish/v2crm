package com.v2crm.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import com.opensymphony.xwork2.ActionSupport;
import com.v2crm.domain.Lead;
import com.v2crm.services.LeadService;
import com.v2crm.util.SpringUtil;

public class LeadAction1 extends ActionSupport implements ServletRequestAware
{
private static final long serialVersionUID = 1L;
private List<Lead> leads = new ArrayList<Lead>();

private HttpServletRequest request;
private static final int MAX_ROW = 10;
	public String displayLeadsList() 
	{
		LeadService leadService = (LeadService) SpringUtil.getSpringUtil().getService("leadService");
		String action = request.getParameter("action");
		String page = request.getParameter(getEncriptedTableIdPaging("leadsTable"));		
		leads = leadService.findAll();
		Integer startRecord = 0; 
		
		if (page !=null && page.trim().length()>0) {
			startRecord = (Integer.parseInt(page) - 1) * MAX_ROW;				
			//Get leads between startRecord and startRecord+MAX_ROW
		} else {
			//Get leads between startRecord and startRecord+MAX_ROW
		}		
	        return SUCCESS;
	}

	public List<Lead> getLeads() {
		return leads;
	}

	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
	
	/**
	 * Get parameter encripted tableId for pagination
	 * @param tableId
	 * @return
	 * return example: d-28374-p
	 */
	public String getEncriptedTableIdPaging(String tableId){
		return new ParamEncoder(tableId).encodeParameterName(TableTagParameters.PARAMETER_PAGE);
	}

	

}