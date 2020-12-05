package org.hospital.entity;

public class recipe {
	private int id;
	private int pid;
	private String pname;
	private int did;
	private String dname;
	private int amount;
	private int price;
	private int state;

	public recipe() {
	}

	public recipe(int id, int pid, String pname, int did, String dname, int amount, int price, int state) {
		super();
		this.id = id;
		this.pid = pid;
		this.pname = pname;
		this.did = did;
		this.dname = dname;
		this.amount = amount;
		this.price = price;
		this.state = state;
	}
	public recipe(int pid, String pname, int did, String dname, int amount, int price, int state) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.did = did;
		this.dname = dname;
		this.amount = amount;
		this.price = price;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
//		return "aaa";
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	

}
