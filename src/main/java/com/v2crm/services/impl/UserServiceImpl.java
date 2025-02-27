package com.v2crm.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.dao.JPADAO;
import com.v2crm.dao.UserDAO;
import com.v2crm.domain.Feature;
import com.v2crm.domain.User;
import com.v2crm.domain.UserType;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.FeatureService;
import com.v2crm.services.UserService;
import com.v2crm.services.UserTypeService;
@Service("userService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=CRMException.class)
public class UserServiceImpl extends CRMServiceImpl<Long, User> implements UserService{
	@Autowired
    protected UserDAO userDAO;
	
	@Autowired
	 private UserTypeService userTypeService;
	
	@Autowired
	private FeatureService featureService;

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) userDAO);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	userDAO.setEntityManager(entityManager);
    }
    
    @Transactional
    public void setupData() throws CRMException{
    	setUpUserTypes();
    	setUpUsers();
    	assignFeaturesToAdmin();
    	assignFeaturesToSalesRep();
    	
    	
    }
    
    void setUpUserTypes(){
    	UserType type1 = new UserType();
    	type1.setUserType("SalesRep");
    	userTypeService.save(type1);
    	
    	type1 = new UserType();
    	type1.setUserType("Admin");
    	userTypeService.save(type1);
    	
    	type1 = new UserType();
    	type1.setUserType("SalesManager");
    	userTypeService.save(type1);
    	
    	type1 = new UserType();
    	type1.setUserType("CoordinationManager");
    	userTypeService.save(type1);
    	
    	type1 = new UserType();
    	type1.setUserType("SalesHead");
    	userTypeService.save(type1);
    	
    	type1 = new UserType();
    	type1.setUserType("CEO");
    	userTypeService.save(type1);
    	
    	type1 = new UserType();
    	type1.setUserType("Support");
    	userTypeService.save(type1);
    }
    
    void setUpUsers(){
    	String userTypeQry = "UserType.findByType";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userType", "Admin");
		List<UserType> types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			User user = new User();
			user.setFirstName("Vraj");
			user.setLastName("Sutaria");
			user.setUserName("vraj");
			user.setPassword("vraj");
			user.setUserType(userType);
			user = (User) super.saveOrUpdate(user);
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
		
		userTypeQry = "UserType.findByType";
		params = new HashMap<String, Object>();
		params.put("userType", "SalesRep");
		types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			User user = new User();
			user.setFirstName("Jatin");
			user.setLastName("Sutaria");
			user.setUserName("jatin");
			user.setPassword("jatin");
			user.setUserType(userType);
			user = (User) super.saveOrUpdate(user);
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
		
		userTypeQry = "UserType.findByType";
		params = new HashMap<String, Object>();
		params.put("userType", "CoordinationManager");
		types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			User user = new User();
			user.setFirstName("Mahesh");
			user.setLastName("Laddha");
			user.setUserName("mahesh");
			user.setPassword("mahesh");
			user.setUserType(userType);
			user = (User) super.saveOrUpdate(user);
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
		
		userTypeQry = "UserType.findByType";
		params = new HashMap<String, Object>();
		params.put("userType", "CEO");
		types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			User user = new User();
			user.setFirstName("Jai");
			user.setLastName("Kisan");
			user.setUserName("jai");
			user.setPassword("jai");
			user.setUserType(userType);
			user = (User) super.saveOrUpdate(user);
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
    }
    
    void assignFeaturesToSalesRep(){
    	String userTypeQry = "UserType.findByType";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userType", "SalesRep");
		List<UserType> types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			Feature feature = new Feature();
			feature.setFeatureName("Leads");
			//feature.setFeaturePage("contacts.jsp");
			List<UserType> userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			
			feature = new Feature();
			feature.setFeatureName("Contacts");
			//feature.setFeaturePage("contacts.jsp");
			userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			
			feature = new Feature();
			feature.setFeatureName("Organizations");
			//feature.setFeaturePage("contacts.jsp");
			userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			
			feature = new Feature();
			feature.setFeatureName("Campaigns");
			//feature.setFeaturePage("contacts.jsp");
			userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			
			feature = new Feature();
			feature.setFeatureName("Oppurtunities");
			//feature.setFeaturePage("contacts.jsp");
			userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
    }
    
    void assignFeaturesToAdmin(){
    	String userTypeQry = "UserType.findByType";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userType", "Admin");
		List<UserType> types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			Feature feature = new Feature();
			feature.setFeatureName("Users");
			//feature.setFeaturePage("contacts.jsp");
			List<UserType> userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			
			feature = new Feature();
			feature.setFeatureName("UserTypes");
			//feature.setFeaturePage("contacts.jsp");
			userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			
			feature = new Feature();
			feature.setFeatureName("Features");
			//feature.setFeaturePage("contacts.jsp");
			userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
    }
}

