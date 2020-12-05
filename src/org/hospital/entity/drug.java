package org.hospital.entity;

public class drug {
	private String sno;
	private String name;
	private String factory;
	private String unit;
	private int number;
	private String price;
	public drug(String sno,String name,String factory,String unit,int number,String price) {
		this.factory=factory;
		this.name=name;
		this.number=number;
		this.price=price;
		this.sno=sno;
		this.unit=unit;
	}
	public drug(String sno,String name,String factory,String unit,String price) {
		this.factory=factory;
		this.name=name;
		this.price=price;
		this.sno=sno;
		this.unit=unit;
	}
	public drug(String sno,String name,int number) {
		this.name=name;
		this.sno=sno;
		this.number=number;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
