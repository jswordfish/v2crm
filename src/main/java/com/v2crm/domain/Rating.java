package com.v2crm.domain;

public enum Rating {
Hot("Hot"), Warm("Warm"), Cold("Cold");
	private String msg;
	Rating(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}

}
