package com.v2crm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name="UserType.findByType",
                query="SELECT c FROM UserType c WHERE c.userType = :userType")
   
}) 
public class UserType extends Base{
@Column(unique=true, nullable=false)
private String userType;

public String getUserType() {
	return userType;
}

public void setUserType(String userType) {
	this.userType = userType;
}


	

}
