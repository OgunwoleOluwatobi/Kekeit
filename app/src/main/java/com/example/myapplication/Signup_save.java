package com.example.myapplication;

public class Signup_save {
    public String name;
    public String phone;
    public String course;
    public String password;

    public Signup_save() {

    }

    public Signup_save(String name, String phone, String course, String password) {
        this.name = name;
        this.phone = phone;
        this.course = course;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
