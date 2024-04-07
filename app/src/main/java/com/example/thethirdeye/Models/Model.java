package com.example.thethirdeye.Models;

public class Model {
    String name,timeStamp;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Model(String name, String timeStamp) {
        this.name = name;
        this.timeStamp = timeStamp;
    }

    public Model() {
    }
}
