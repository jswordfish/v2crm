package com.v2crm.web.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.v2crm.domain.LeadSource;
import com.v2crm.domain.Oppurtunity;
import com.v2crm.domain.OppurtunityStrategy;
import com.v2crm.domain.OppurtunityType;
import com.v2crm.domain.SalesStage;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.OppurtunityService;
import com.v2crm.util.DataList;
import com.v2crm.util.SpringUtil;

public class OppurtunityAction extends ActionSupport implements ServletRequestAware {
	Logger logger = LoggerFactory.getLogger(OppurtunityAction.class);
	//private Org orgService;
	
	private OppurtunityService oppurtunityService;
	
	private DataList dataList;
	
	HttpServletRequest httpServletRequest;
	
	public String display() 
	{
		oppurtunityService = (OppurtunityService)SpringUtil.getSpringUtil().getService("oppurtunityService");
		List<Oppurtunity> oppurtunities = oppurtunityService.findAll();
		
	        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
	        if(httpServletRequest != null){
	        	dataList = new DataList(httpServletRequest);
	        	dataList.setList(oppurtunities);
	        }
	        else{
	        	dataList = new DataList();
	        	dataList.setList(oppurtunities);
	        }
	        
	        httpServletRequest.setAttribute( "data", dataList );
	        return SUCCESS;
	}



	public String delete(){
		oppurtunityService = (OppurtunityService)SpringUtil.getSpringUtil().getService("oppurtunityService");
		String id = httpServletRequest.getParameter("id");
		if(id != null){
			
		}
		oppurtunityService.delete(Long.parseLong(id));
		List<Oppurtunity> oppurtunities = oppurtunityService.findAll();
		
        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
        if(httpServletRequest != null){
        	dataList = new DataList(httpServletRequest);
        	dataList.setList(oppurtunities);
        }
        else{
        	dataList = new DataList();
        	dataList.setList(oppurtunities);
        }
        
        httpServletRequest.setAttribute( "data", dataList );
        return "delete_success";
	}
	
	
	public String edit(){
		oppurtunityService = (OppurtunityService)SpringUtil.getSpringUtil().getService("oppurtunityService");
		if(httpServletRequest.getParameter("id") != null){
			Long id = Long.parseLong(httpServletRequest.getParameter("id"));
			Oppurtunity oppurtunity = (Oppurtunity) oppurtunityService.find(id);
			httpServletRequest.setAttribute("oppurtunity", oppurtunity);
		}
	    return "edit_success";
	}
	
	public String save(){
		try {
			oppurtunityService = (OppurtunityService)SpringUtil.getSpringUtil().getService("oppurtunityService");
			Oppurtunity oppurtunity = (Oppurtunity) httpServletRequest.getSession().getAttribute("oppurtunity");
			
			oppurtunity.setAmount(Long.parseLong(httpServletRequest.getParameter("amount")));
			oppurtunity.setDescription(httpServletRequest.getParameter("description"));
			String eCDt = httpServletRequest.getParameter("expectedClosedDate");
			if(eCDt == null){
				eCDt = eCDt.trim();
			}
			if(eCDt != "" && eCDt != null){
				Date date = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(eCDt);
				oppurtunity.setExpectedClosedDate(date);
			}
			
			oppurtunity.setLeadSource(LeadSource.valueOf(httpServletRequest.getParameter("leadSource")));
			oppurtunity.setOppurtunityName(httpServletRequest.getParameter("oppurtunityName"));
			oppurtunity.setOppurtunityStrategy(OppurtunityStrategy.valueOf(httpServletRequest.getParameter("oppurtunityStrategy")));
			
			oppurtunity.setOppurtunityType(OppurtunityType.valueOf(httpServletRequest.getParameter("oppurtunityType")));
			oppurtunity.setPrimaryEmail(httpServletRequest.getParameter("primaryEmail"));
			oppurtunity.setProbability(Integer.parseInt(httpServletRequest.getParameter("probability")));
			
			oppurtunity.setSalesStage(SalesStage.valueOf(httpServletRequest.getParameter("salesStage")));
			oppurtunity.setOppurtunityName(httpServletRequest.getParameter("oppurtunityName"));
			oppurtunity.setOppurtunityType(OppurtunityType.valueOf(httpServletRequest.getParameter("oppurtunityType")));
		
			oppurtunity.setDescription(httpServletRequest.getParameter("description"));
			httpServletRequest.setAttribute("oppurtunity", oppurtunity);
			if(oppurtunity.getId() == null){
				oppurtunityService.save(oppurtunity);
			}
			else{
				oppurtunityService.saveOrUpdate(oppurtunity);
			}
			
			return "save_success";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Can not save oppurtunity", e);
		} 
		catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Can not save oppurtunity", e);
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Can not save oppurtunity", e);
		}
		return "save_failure";
	}

	
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.httpServletRequest = arg0;  
	}

	

}
