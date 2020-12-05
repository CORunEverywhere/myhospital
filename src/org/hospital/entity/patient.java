package org.hospital.entity;

public class patient {
	private int id;
	private String username;
	private String name;
	private String sex;
	private int year;
	private String phone;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public patient(int id, String username,String name, String sex, int year, String phone, String password) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.sex = sex;
		this.year = year;
		this.phone = phone;
		this.password = password;
	}
	public patient(String username,String name, String sex, int year, String phone, String password) {
		this.username = username;
		this.name = name;
		this.sex = sex;
		this.year = year;
		this.phone = phone;
		this.password = password;
	}
	public patient() {
	}
	

}
