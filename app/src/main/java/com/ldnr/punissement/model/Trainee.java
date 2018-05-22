package com.ldnr.punissement.model;

public class Trainee {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Trainee() {
    }

    public Trainee(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {

        return phone;
    }

    public void setPhoneNum(String phone) {
        this.phone = phone;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
