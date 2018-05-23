package com.ldnr.punissement.model;

public class Location {

    public static final String TABLE_NAME = "location";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LOCNAME = "locName";

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_LOCNAME + " VARCHAR(255) NOT NULL,"
                    + ")";

    private int id;
    private String locName;

    // default constructor
    public Location(){
    }

    // constructor by parameters
    public Location(int id, String locName) {
        this.id = id;
        this.locName = locName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }
}
