package com.v2crm.domain;

public enum State {
	AndhraPradesh("AndhraPradesh"), ArunachalPradesh("ArunachalPradesh"), Assam("Assam"), Bihar("Bihar"), Chhattisgarh("Chhattisgarh"), 
	Goa("Goa"), Gujarat("Gujarat"), Haryana("Haryana"), HimachalPradesh("HimachalPradesh"), JammuAndKashmir("JammuAndKashmir"), Jharkhand("Jharkhand"),
	Karnataka("Karnataka"), Kerala("Kerala"), MadhyaPradesh("MadhyaPradesh"), Maharashtra("Maharashtra"), Manipur("Manipur"), Meghalaya("Meghalaya"),
	Mizoram("Mizoram"), Nagaland("Nagaland"), Odisha("Odisha"), Punjab("Punjab"), Rajasthan("Rajasthan"),
	Sikkim("Sikkim"), TamilNadu("TamilNadu"), Telangana("Telangana"), Tripura("Tripura"), UttarPradesh("UttarPradesh"), Uttarakhand("Uttarakhand"),
	WestBengal("WestBengal");
	
	String code;
	
	private State(String cod){
		this.code = cod;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
