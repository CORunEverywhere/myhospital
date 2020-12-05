package org.hospital.entity;

public class Doctor {
	private int id;
	private String name;
	private String sex;
	private int birthYear;
	private String title;
	private String department;
	private String password;
	private String address;
	private String phonenumber;
	public Doctor(int id, String name, String sex, int birthYear, String title, String department, String password, String address, String phonenumber) {
		this.id = id;
		this.address = address;
		this.birthYear = birthYear;
		this.department = department;
		this.name = name;
		this.password = password;
		this.phonenumber = phonenumber;
		this.sex = sex;
		this.title = title;
	}
	public Doctor(String name, String sex, int birthYear, String title, String department, String password, String address, String phonenumber) {
		this.address = address;
		this.birthYear = birthYear;
		this.department = department;
		this.name = name;
		this.password = password;
		this.phonenumber = phonenumber;
		this.sex = sex;
		this.title = title;
	}
	public Doctor(String name, String sex, int birthYear, String title, String department, String address, String phonenumber) {
		this.address = address;
		this.birthYear = birthYear;
		this.department = department;
		this.name = name;
		this.phonenumber = phonenumber;
		this.sex = sex;
		this.title = title;
	}
	public Doctor() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}
