package com.busify.bus.dto;

public class User {
    private String name;
    private String age;
    private String phoneNumber;

    private String password;




    public User(String name, String age, String phoneNumber, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;

        this.password = password;
    }
    public User() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
