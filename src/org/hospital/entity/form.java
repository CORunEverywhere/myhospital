package org.hospital.entity;

public class form {
	private int id;
	private int pid;
	private String pname;
	private int did;
	private String dname;
	private String time;
	private int state;
	public int getState() {
		return state;
	}
	public void setState(int state) {
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public form(int id, int pid, String pname, int did, String dname, String time,int state) {
		this.id = id;
		this.pid = pid;
		this.pname = pname;
		this.did = did;
		this.dname = dname;
		this.time = time;
		this.state = state;
	}
	public form( int pid, String pname, int did, String dname, String time,int state) {
		this.pid = pid;
		this.pname = pname;
		this.did = did;
		this.dname = dname;
		this.time = time;
		this.state = state;
	}
	public form( int pid, String pname, int did, String dname,int state) {
		this.pid = pid;
		this.pname = pname;
		this.did = did;
		this.dname = dname;
		this.state = state;
	}
}
