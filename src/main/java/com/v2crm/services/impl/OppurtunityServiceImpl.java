package com.v2crm.services.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.dao.JPADAO;
import com.v2crm.dao.OppurtunityDAO;
import com.v2crm.domain.Oppurtunity;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.OppurtunityService;
@Service("oppurtunityService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=CRMException.class)
public class OppurtunityServiceImpl extends CRMServiceImpl<Long, Oppurtunity> implements OppurtunityService{
	@Autowired
    protected OppurtunityDAO oppurtunityDAO;
	
	 

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) oppurtunityDAO);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	oppurtunityDAO.setEntityManager(entityManager);
    }
    
 
}
