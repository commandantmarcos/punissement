package com.ldnr.punissement.model;

public class Trainee {
    public static final String TABLE_NAME = "trainee";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_GROUP_ID = "group_id";

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int group_id;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_FIRSTNAME + " VARCHAR(255) NOT NULL,"
                    + COLUMN_LASTNAME + " VARCHAR(255) NOT NULL,"
                    + COLUMN_PHONE + " VARCHAR(255) NULL,"
                    + COLUMN_EMAIL + " VARCHAR(255) NULL"
                    + COLUMN_GROUP_ID + " INTEGER FOREIGN KEY AUTOINCREMENT"
                    + ")";

    // default constructor
    public Trainee() {
    }

    // constructor by parameters
    public Trainee(int id, String firstName, String lastName, String phone, String email, int group_id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.group_id = group_id;
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

    public int getGroupId() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

}
