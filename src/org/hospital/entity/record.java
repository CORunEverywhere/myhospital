package org.hospital.entity;

public class record {
	private int sno;
	private String drugSno;
	private String drugSname;
	private int personSno;
	private String personSname;
	private int number;
	private String time;
	public record(int sno,String drugSno,String drugSname,int personSno,String personSname,int number,String time) {
		this.drugSname=drugSname;
		this.drugSno=drugSno;
		this.number=number;
		this.personSname=personSname;
		this.personSno=personSno;
		this.sno=sno;
		this.time=time;
	}
	public record(int sno,String drugSno,String drugSname,int number,String time) {
		this.drugSname=drugSname;
		this.drugSno=drugSno;
		this.number=number;
		this.sno=sno;
		this.time=time;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getDrugSno() {
		return drugSno;
	}
	public void setDrugSno(String drugSno) {
		this.drugSno = drugSno;
	}
	public String getDrugSname() {
		return drugSname;
	}
	public void setDrugSname(String drugSname) {
		this.drugSname = drugSname;
	}
	public int getPersonSno() {
		return personSno;
	}
	public void setPersonSno(int personSno) {
		this.personSno = personSno;
	}
	public String getPersonSname() {
		return personSname;
	}
	public void setPersonSname(String personSname) {
		this.personSname = personSname;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	

}
