package com.ldnr.punissement.model;

import java.sql.Timestamp;

public class Task {

    public static final String TABLE_NAME = "task";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_TASKNAME = "taskname";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_LOC = "loc";

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TYPE + " VARCHAR(255) NOT NULL,"
                    + COLUMN_TASKNAME + " VARCHAR(255) NOT NULL,"
                    + COLUMN_DATE + " VARCHAR(255) NULL,"
                    + COLUMN_LOC + " VARCHAR(255) NULL"
                    + ")";

    private int id;
    private String type;
    private String taskName;
    private Timestamp date;
    private Location loc;


    // default constructor
    public Task(){
    }

    // constructor by parameters
    public Task(int id, String type, String taskName, Timestamp date, Location loc) {
        this.id = id;
        this.type = type;
        this.taskName = taskName;
        this.date = date;
        this.loc = loc;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }
}
