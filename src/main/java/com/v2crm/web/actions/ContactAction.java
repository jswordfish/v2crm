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
import com.v2crm.domain.Contact;
import com.v2crm.domain.Industry;
import com.v2crm.domain.LeadSource;
import com.v2crm.domain.MessengerType;
import com.v2crm.domain.Rating;
import com.v2crm.domain.State;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.ContactService;
import com.v2crm.util.DataList;
import com.v2crm.util.SpringUtil;

public class ContactAction extends ActionSupport implements ServletRequestAware {
	Logger logger = LoggerFactory.getLogger(ContactAction.class);
	//private Org orgService;
	
	private ContactService contactService;
	
	private DataList dataList;
	
	HttpServletRequest httpServletRequest;
	
	public String display() 
	{
		contactService = (ContactService)SpringUtil.getSpringUtil().getService("contactService");
		List<Contact> contacts = contactService.findAll();
		
	        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
	        if(httpServletRequest != null){
	        	dataList = new DataList(httpServletRequest);
	        	dataList.setList(contacts);
	        }
	        else{
	        	dataList = new DataList();
	        	dataList.setList(contacts);
	        }
	        
	        httpServletRequest.setAttribute( "data", dataList );
	        return SUCCESS;
	}



	public String delete(){
		contactService = (ContactService)SpringUtil.getSpringUtil().getService("contactService");
		String orgId = httpServletRequest.getParameter("id");
		if(orgId != null){
			
		}
		contactService.delete(Long.parseLong(orgId));
		List<Contact> contacts = contactService.findAll();
		
        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
        if(httpServletRequest != null){
        	dataList = new DataList(httpServletRequest);
        	dataList.setList(contacts);
        }
        else{
        	dataList = new DataList();
        	dataList.setList(contacts);
        }
        
        httpServletRequest.setAttribute( "data", dataList );
        return "delete_success";
	}
	
	
	public String edit(){
		contactService = (ContactService)SpringUtil.getSpringUtil().getService("contactService");
		if(httpServletRequest.getParameter("id") != null){
			Long orgId = Long.parseLong(httpServletRequest.getParameter("id"));
			Contact contact = (Contact) contactService.find(orgId);
			httpServletRequest.setAttribute("contact", contact);
		}
	    return "edit_success";
	}
	
	public String save(){
		try {
			contactService = (ContactService)SpringUtil.getSpringUtil().getService("contactService");
			Contact contact = (Contact) httpServletRequest.getSession().getAttribute("contact");
			contact.setFirstName(httpServletRequest.getParameter("firstName"));
			contact.setLastName(httpServletRequest.getParameter("lastName"));
			contact.setCompany(httpServletRequest.getParameter("company"));
			
			contact.setPrimaryEmail(httpServletRequest.getParameter("primaryEmail"));
			contact.setPersonalEmail(httpServletRequest.getParameter("personalEmail"));
			contact.setHomePhone(httpServletRequest.getParameter("homePhone"));
			
			contact.setOfficePhone(httpServletRequest.getParameter("officePhone"));
			contact.setMobilePhone(httpServletRequest.getParameter("mobilePhone"));
			contact.setDesignation(httpServletRequest.getParameter("designation"));
			
			String dt = httpServletRequest.getParameter("dateOfBirth");
			if(dt == null){
				dt = dt.trim();
			}
			if(dt != "" && dt != null){
				Date date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(dt);
				contact.setDateOfBirth(date);
			}
			
			contact.setMessengerType(MessengerType.valueOf(httpServletRequest.getParameter("messengerType")));
			contact.setMessengerID(httpServletRequest.getParameter("messengerID"));
			
			contact.setReference((Boolean.getBoolean(httpServletRequest.getParameter("reference"))));
			contact.setReportsTo(httpServletRequest.getParameter("reportsTo"));
			contact.setFax(httpServletRequest.getParameter("fax"));
			
			contact.setDoNotCall((Boolean.getBoolean(httpServletRequest.getParameter("doNotCall"))));
			contact.setDepartment(httpServletRequest.getParameter("department"));
			contact.setContactSource(LeadSource.valueOf(httpServletRequest.getParameter("contactSource")));
			
			contact.getOfficeAddress().setCity(httpServletRequest.getParameter("city"));
			contact.getOfficeAddress().setStreet(httpServletRequest.getParameter("street"));
			contact.getOfficeAddress().setBldg(httpServletRequest.getParameter("building"));
			
			contact.getOfficeAddress().setOfficeNumber(httpServletRequest.getParameter("officeNumber"));
			contact.getOfficeAddress().setPin(httpServletRequest.getParameter("zip"));
			contact.getOfficeAddress().setState(State.valueOf(httpServletRequest.getParameter("state")));
			contact.getOfficeAddress().setCountry(httpServletRequest.getParameter("country"));
			
			contact.getHomeAddress().setCity(httpServletRequest.getParameter("city_home"));
			contact.getHomeAddress().setStreet(httpServletRequest.getParameter("street_home"));
			contact.getHomeAddress().setBldg(httpServletRequest.getParameter("building_home"));
			
			contact.getHomeAddress().setOfficeNumber(httpServletRequest.getParameter("officeNumber_home"));
			contact.getHomeAddress().setPin(httpServletRequest.getParameter("zip_home"));
			contact.getHomeAddress().setState(State.valueOf(httpServletRequest.getParameter("state_home")));
			contact.getHomeAddress().setCountry(httpServletRequest.getParameter("country_home"));
			httpServletRequest.setAttribute("contact", contact);
			if(contact.getId() == null){
				contactService.save(contact);
			}
			else{
				contactService.saveOrUpdate(contact);
			}
			
			return "save_success";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "save_failure";
	}

	
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.httpServletRequest = arg0;  
	}

	

}
