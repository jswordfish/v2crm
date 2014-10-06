package com.v2crm.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Table(uniqueConstraints=
        @UniqueConstraint(columnNames={"firstName", "lastName"}))
@Entity
@Indexed
public class User extends Base{

@Field(index=org.hibernate.search.annotations.Index.YES, analyze=Analyze.YES, store=Store.NO)
@Column(nullable=false) 
private String firstName;

@Field(index=org.hibernate.search.annotations.Index.YES, analyze=Analyze.YES, store=Store.NO)
@Column(nullable=false) 
private String lastName;

private boolean isEmployee = true;

@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="userType_id",insertable=true, updatable=true)
private UserType userType;

@Column(nullable=false, unique=true)
private String userName;

@Column(nullable=false)
private String password;

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public boolean isEmployee() {
	return isEmployee;
}

public void setEmployee(boolean isEmployee) {
	this.isEmployee = isEmployee;
}

public UserType getUserType() {
	return userType;
}

public void setUserType(UserType userType) {
	this.userType = userType;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



}
