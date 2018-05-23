package com.ldnr.punissement.model;

public class Trainee {
    public static final String TABLE_NAME = "trainee";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_FIRSTNAME + " VARCHAR(255) NOT NULL,"
                    + COLUMN_LASTNAME + " VARCHAR(255) NOT NULL,"
                    + COLUMN_PHONE + " VARCHAR(255) NULL,"
                    + COLUMN_EMAIL + " VARCHAR(255) NULL"
                    + ")";

    // default constructor
    public Trainee() {
    }

    // constructor by parameters
    public Trainee(int id, String firstName, String lastName, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
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
