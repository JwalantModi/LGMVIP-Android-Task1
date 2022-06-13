package com.internship.lgmtask1.model;

public class City {
    private String name;
    private String currCases;

    public City(String name, String currCases) {

        this.name = name;
        this.currCases = currCases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrCases() {
        return currCases;
    }

    public void setCurrCases(String currCases) {
        this.currCases = currCases;
    }
}
