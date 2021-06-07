package com.readdata.Entity;

public class Account {
	
	private String id;
	private String account_type;
	private String ptype;
	private String amount;
	private String Remark;
	private String Name;
	private String Date;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String id, String account_type, String ptype, String amount, String remark, String name, String date) {
		super();
		this.id = id;
		this.account_type = account_type;
		this.ptype = ptype;
		this.amount = amount;
		Remark = remark;
		Name = name;
		Date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	

}
