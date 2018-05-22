package com.ldnr.punissement.model;

public class Location {

    private int id_loc;
    private String locName;

    public Location(int id_loc, String locName) {
        this.id_loc = id_loc;
        this.locName = locName;
    }

    public int getId_loc() {
        return id_loc;
    }

    public void setId_loc(int id_loc) {
        this.id_loc = id_loc;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }
}
