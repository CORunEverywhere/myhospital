package org.hospital.entity;

public class DepotKeeper {
    private int id;
    private String name;
    private String sex;
    private String birthYear;
    private String password;
    private String address;
    private String phonenumber;
    public DepotKeeper(int id,String name,String sex,String birthYear,String password,String address,String phonenumber) {
        this.id = id;
        this.address = address;
        this.birthYear = birthYear;
        this.name = name;
        this.password = password;
        this.phonenumber = phonenumber;
        this.sex = sex;
    }
    public DepotKeeper(String name,String sex,String birthYear,String password,String address,String phonenumber) {
        this.address = address;
        this.birthYear = birthYear;
        this.name = name;
        this.password = password;
        this.phonenumber = phonenumber;
        this.sex = sex;
    }
    public DepotKeeper(String name,String sex,String birthYear,String address,String phonenumber) {
        this.address = address;
        this.birthYear = birthYear;
        this.name = name;
        this.phonenumber = phonenumber;
        this.sex = sex;
    }
    public DepotKeeper() {

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
    public String getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
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
