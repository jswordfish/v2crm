package com.v2.services.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.domain.Address;
import com.v2crm.domain.Industry;
import com.v2crm.domain.Lead;
import com.v2crm.domain.State;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.LeadService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class CRMServiceTest {
	@Autowired
	LeadService leadService;
	
	@Test
	@Rollback(value=false)
	public void testLeadCreation(){
		try {
			for(int i=0;i<20;i++){
				Lead lead = new Lead();
				lead.setCompany("Company"+i);
				lead.setDesignation("Executive");
				lead.setFirstName("Ram"+i);
				lead.setIndustry(Industry.Banking);
				lead.setLastName("Kadam");
				lead.setMobile("8686878");
				lead.setPrimaryEmail("rrt@trt.com");
				lead.setWebsite("www.comp1.com");
				Address address = new Address();
				address.setBldg("mount view"+i);
				address.setCity("Mumbai");
				address.setOfficeNumber("502"+i);
				address.setPin("400080"+i);
				address.setStreet("Off Bal rajeshwar rd");
				address.setState(State.Maharashtra);
				lead.setAddress(address);
				leadService.save(lead);
			}
			
		} catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}

}
