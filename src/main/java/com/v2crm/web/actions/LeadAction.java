package com.v2crm.web.actions;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.v2crm.domain.Lead;
import com.v2crm.services.LeadService;
import com.v2crm.util.DataList;
import com.v2crm.util.SpringUtil;
public class LeadAction extends ActionSupport implements ServletRequestAware {
	Logger logger = LoggerFactory.getLogger(LeadAction.class);
	private LeadService leadService;
	
	private DataList dataList;
	
	HttpServletRequest httpServletRequest;
	
	public String displayLeads() 
	{
		leadService = (LeadService)SpringUtil.getSpringUtil().getService("leadService");
		List<Lead> leads = leadService.findAll();
		
	        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
	        if(httpServletRequest != null){
	        	dataList = new DataList(httpServletRequest);
	        	dataList.setList(leads);
	        }
	        else{
	        	dataList = new DataList();
	        	dataList.setList(leads);
	        }
	        
	        httpServletRequest.setAttribute( "data", dataList );
	        return SUCCESS;
	}



	public String deleteLead(){
		String leadId = httpServletRequest.getParameter("id");
		leadService.delete(Long.parseLong(leadId));
		List<Lead> leads = leadService.findAll();
		
        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
        if(httpServletRequest != null){
        	dataList = new DataList(httpServletRequest);
        	dataList.setList(leads);
        }
        else{
        	dataList = new DataList();
        	dataList.setList(leads);
        }
        
        httpServletRequest.setAttribute( "data", dataList );
        return "delete_success";
	}
	
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.httpServletRequest = arg0;  
	}

	

}


