package com.trg.model;

public class Account {

	int acctId;
	String aname, type;
	double bal;

	//get/set, cons, toString()
	
	public int getAcctId() {
		return acctId;
	}

	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int acctId, String aname, String type, double bal) {
		super();
		this.acctId = acctId;
		this.aname = aname;
		this.type = type;
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "Account [acctId=" + acctId + ", aname=" + aname + ", type=" + type + ", bal=" + bal + "]";
	}

}
