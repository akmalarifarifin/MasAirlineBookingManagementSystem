package com.example.MasAirlineBookingManagementSystem.Model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    public User(Long id, String phoneNumber, String email, String name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
