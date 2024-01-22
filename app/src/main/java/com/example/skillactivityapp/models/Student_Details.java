package com.example.skillactivityapp.models;

public class Student_Details {
    private String username;
    private String Password;
    private String Name;
    private String Branch;
    private String Course;
    private String Phone_no;

    public Student_Details(String username, String password, String name, String branch, String course, String phone_no) {
        this.username = username;
        Password = password;
        Name = name;
        Branch = branch;
        Course = course;
        Phone_no = phone_no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getPhone_no() {
        return Phone_no;
    }

    public void setPhone_no(String phone_no) {
        Phone_no = phone_no;
    }
}
