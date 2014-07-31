package com.v2crm.web.actions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.v2crm.domain.Lead;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.LeadService;
public class LeadAction extends ActionSupport implements Preparable {
	Logger logger = LoggerFactory.getLogger(LeadAction.class);
	private LeadService leadService;
	
	private List<Lead> leads;
	
	private String page;  
    private Integer total;  
    private String records;  
    private List rows; 

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	 public String execute() {
		try {
			 page = "1";
		     total = 1;     
			leads = leadService.findAll();
			records = leads.size()+"";
			rows = new ArrayList();
			int number = 1;
				for(Lead lead: leads){
					Row row = new Row();
					row.setNumber(""+number);
					row.setCell(new String[]{lead.getFirstName(), lead.getLastName(), lead.getCompany(), lead.getMobile(), lead.getPrimaryEmail(), lead.getIndustry().toString()});
					number++;
					//rows.add(new )
				}
				//total =(int) Math.ceil(Integer.parseInt(records) / (double)rows);
			return SUCCESS;
		} catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("can not fetch leads", e);
			return ERROR;
		}
	}

	

	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public List<Lead> getLeads() {
		return leads;
	}
	
	
	public class Row implements Serializable {
        private String number;
        
        private String[] cell;
        
        public Row() {
            
        }
        
        public Row(String id, String[] cell) {
            setNumber(id);
            setCell(cell);
        }

       

        public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String[] getCell() {
            return cell;
        }

        public void setCell(String[] cell) {
            this.cell = cell;
        }        
        
    }    
	

}


