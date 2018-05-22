package com.ldnr.punissement.model;

import java.sql.Timestamp;

public class Task {

    private int id_task;
    private String type;
    private String taskName;
    private Timestamp date;
    private Location loc;

    public Task(int id_task, String type, String taskName, Timestamp date, Location loc) {
        this.id_task = id_task;
        this.type = type;
        this.taskName = taskName;
        this.date = date;
        this.loc = loc;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
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
