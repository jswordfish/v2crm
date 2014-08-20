package com.v2crm.web.displaytag.decorators;

import org.displaytag.decorator.TableDecorator;

import com.v2crm.domain.Base;

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
	
	

}

