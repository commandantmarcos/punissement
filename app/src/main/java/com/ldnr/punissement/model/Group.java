package com.ldnr.punissement.model;

public class Group {

    public static final String TABLE_NAME = "group";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_GROUPNAME = "groupName";

    private int id;
    private String groupName;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_GROUPNAME + " VARCHAR(255) NOT NULL,"
                    + ")";

    public Group(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
