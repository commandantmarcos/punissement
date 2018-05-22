package com.ldnr.punissement.model;

public class Trainee {

    private int id_trainee;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Trainee() {
    }

    public Trainee(int id_trainee, String firstName, String lastName, String phone, String email) {
        this.id_trainee = id_trainee;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public int getId_trainee() {
        return id_trainee;
    }

    public void setId_trainee(int id_trainee) {
        this.id_trainee = id_trainee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
