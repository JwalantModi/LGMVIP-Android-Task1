package com.internship.lgmtask1.model;

public class City {
    private String name;
    private String currCases;
    private String confCases;
    private String recCases;

    public City(String name, String currCases, String confCases, String recCases) {
        this.name = name;
        this.currCases = currCases;
        this.confCases = confCases;
        this.recCases = recCases;
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

    public String getConfCases() {
        return confCases;
    }

    public void setConfCases(String confCases) {
        this.confCases = confCases;
    }

    public String getRecCases() {
        return recCases;
    }

    public void setRecCases(String recCases) {
        this.recCases = recCases;
    }
}
