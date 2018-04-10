package com.company.bean;

import java.util.Date;
// this is a test one
public class User {

    //这是一张注释
    private String username;

    private String password;

    private Integer age;

    private String headportrait;

    private Date birthday;

    public User() {
    }

    public User(String username, String password, Integer age, String headportrait, Date birthday) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.headportrait = headportrait;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait == null ? null : headportrait.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", headportrait='" + headportrait + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}