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
import com.v2crm.domain.Campaign;
import com.v2crm.domain.CampaignResponseType;
import com.v2crm.domain.CampaignStatus;
import com.v2crm.domain.CampaignType;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.CampaignService;
import com.v2crm.util.DataList;
import com.v2crm.util.SpringUtil;

public class CampaignAction extends ActionSupport implements ServletRequestAware {
	Logger logger = LoggerFactory.getLogger(CampaignAction.class);
	//private Org orgService;
	
	private CampaignService campaignService;
	
	private DataList dataList;
	
	HttpServletRequest httpServletRequest;
	
	public String display() 
	{
		campaignService = (CampaignService)SpringUtil.getSpringUtil().getService("campaignService");
		List<Campaign> campaigns = campaignService.findAll();
		
	        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
	        if(httpServletRequest != null){
	        	dataList = new DataList(httpServletRequest);
	        	dataList.setList(campaigns);
	        }
	        else{
	        	dataList = new DataList();
	        	dataList.setList(campaigns);
	        }
	        
	        httpServletRequest.setAttribute( "data", dataList );
	        return SUCCESS;
	}



	public String delete(){
		campaignService = (CampaignService)SpringUtil.getSpringUtil().getService("campaignService");
		String id = httpServletRequest.getParameter("id");
		if(id != null){
			
		}
		campaignService.delete(Long.parseLong(id));
		List<Campaign> campaigns = campaignService.findAll();
		
        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
        if(httpServletRequest != null){
        	dataList = new DataList(httpServletRequest);
        	dataList.setList(campaigns);
        }
        else{
        	dataList = new DataList();
        	dataList.setList(campaigns);
        }
        
        httpServletRequest.setAttribute( "data", dataList );
        return "delete_success";
	}
	
	
	public String edit(){
		campaignService = (CampaignService)SpringUtil.getSpringUtil().getService("campaignService");
		if(httpServletRequest.getParameter("id") != null){
			Long id = Long.parseLong(httpServletRequest.getParameter("id"));
			Campaign campaign = (Campaign) campaignService.find(id);
			httpServletRequest.setAttribute("campaign", campaign);
		}
	    return "edit_success";
	}
	
	public String save(){
		try {
			campaignService = (CampaignService)SpringUtil.getSpringUtil().getService("campaignService");
			Campaign campaign = (Campaign) httpServletRequest.getSession().getAttribute("campaign");
			campaign.setActualCost(Long.parseLong(httpServletRequest.getParameter("actualCost")));
			campaign.setActualResponseCount(Integer.parseInt(httpServletRequest.getParameter("actualResponseCount")));
			campaign.setActualRevenue(Long.parseLong(httpServletRequest.getParameter("actualRevenue")));
			
			campaign.setCampaignName(httpServletRequest.getParameter("campaignName"));
			campaign.setCampaignResponseType(CampaignResponseType.valueOf(httpServletRequest.getParameter("campaignResponseType")));
			campaign.setCampaignStatus(CampaignStatus.valueOf(httpServletRequest.getParameter("campaignStatus")));
			
			campaign.setCampaignType(CampaignType.valueOf(httpServletRequest.getParameter("campaignType")));
			campaign.setDescription(httpServletRequest.getParameter("description"));
			String eDt = httpServletRequest.getParameter("endDate");
			if(eDt == null){
				eDt = eDt.trim();
			}
			if(eDt != "" && eDt != null){
				Date date = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(eDt);
				campaign.setEndDate(date);
			}
			
			campaign.setEstimatedCost(Long.parseLong(httpServletRequest.getParameter("estimatedCost")));
			String cnt1  =httpServletRequest.getParameter("expectedResponseCost");
			campaign.setExpectedResponseCount((int)Long.parseLong(cnt1));
			String cnt2 = httpServletRequest.getParameter("expectedRevenue");
			campaign.setExpectedRevenue(Long.parseLong(cnt2));
			
			String sDt = httpServletRequest.getParameter("startDate");
			if(sDt == null){
				sDt = sDt.trim();
			}
			if(sDt != "" && sDt != null){
				Date date = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(sDt);
				campaign.setStartDate(date);
			}
			
			
			
			httpServletRequest.setAttribute("campaign", campaign);
			if(campaign.getId() == null){
				campaignService.save(campaign);
			}
			else{
				campaignService.saveOrUpdate(campaign);
			}
			
			return "save_success";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Can not save campaign", e);
		} 
		catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Can not save campaign", e);
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Can not save campaign", e);
		}
		return "save_failure";
	}

	
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.httpServletRequest = arg0;  
	}

	

}
