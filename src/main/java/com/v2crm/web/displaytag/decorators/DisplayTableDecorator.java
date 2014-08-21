package com.v2crm.web.displaytag.decorators;

import org.displaytag.decorator.TableDecorator;

import com.v2crm.domain.Base;
import com.v2crm.domain.Organization;

public class DisplayTableDecorator extends TableDecorator{
	
	public String getEditLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"EditLead?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	public String getDeleteLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"DeleteLead?id="+base.getId()+"\"><img src=\"images/Delete.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	public String getOrganizationType(){
		Organization org = (Organization)getCurrentRowObject();
		if(org != null){
			return org.getOrganizationType().getMsg();
			//return "<A HREF=\"EditOrganization?id="+org.getId()+"\"><img src=\"images/Edit.png\"></A>";
		}
		return "";
	}
	
	public String getRevenueRange(){
		Organization org = (Organization)getCurrentRowObject();
		if(org != null){
			return org.getRevenueRange().getMsg();
			
		}
		return "";
	}
	
	public String getIndustryForOrg(){
		Organization org = (Organization)getCurrentRowObject();
		if(org != null){
			return org.getIndustry().getMsg();
			//return "<A HREF=\"EditOrganization?id="+org.getId()+"\"><img src=\"images/Edit.png\"></A>";
		}
		return "";
	}
	
	public String getEditLinkForOrg(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"EditOrganization?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	public String getDeleteLinkForOrg(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"DeleteOrganization?id="+base.getId()+"\"><img src=\"images/Delete.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	public String getEditLinkForContact(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"EditContact?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	public String getDeleteLinkForContact(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"DeleteContact?id="+base.getId()+"\"><img src=\"images/Delete.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	

}

