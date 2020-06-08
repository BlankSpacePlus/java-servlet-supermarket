package com.smbs.entity;

import java.util.Date;

public class SuperUsers {

    private String userID;

    private String userName;

    private String passWord;

    private String phone;

    private String address;

    private Date birthday;

    private int role;

    public SuperUsers() {}

    public SuperUsers(String userID, String userName, String passWord, String phone, String address, Date birthday,
                      int role) {
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
