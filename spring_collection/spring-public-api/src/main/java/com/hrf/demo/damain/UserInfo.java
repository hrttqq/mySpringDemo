package com.hrf.demo.damain;

import java.io.Serializable;

public class UserInfo implements Serializable {
    public int id;
    public String userName = "吕小布";
    public String userId;
    public int age;
    public long phone;

    public UserInfo() {
    }

    public UserInfo(int id, String userName, String userId, int age, long phone) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
        this.age = age;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
