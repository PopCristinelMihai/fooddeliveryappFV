package com.example.fooddelivery.Model;

public class User {

    private String name;
    private String password;
    private String Phone;
    private String isStaff;

    public User(){

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.isStaff="false";

    }

    public String getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(String isStaff) {
        this.isStaff = isStaff;
    }

    public String getPhone() {
        return Phone;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
