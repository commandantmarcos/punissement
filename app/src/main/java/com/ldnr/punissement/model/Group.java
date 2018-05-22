package com.ldnr.punissement.model;

public class Group {

    private int id_group;
    private String groupName;

    public Group(int id_group, String groupName) {
        this.id_group = id_group;
        this.groupName = groupName;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
