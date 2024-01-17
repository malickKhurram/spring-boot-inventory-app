package com.eperfections.inventory.user;

import jakarta.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String name;
    private String location;
    private String phone;
    private String username;
    private String password;

    public User(){

    }
    public User(long userId, String name, String location, String phone, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public User(String name, String location, String phone, String username, String password) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
