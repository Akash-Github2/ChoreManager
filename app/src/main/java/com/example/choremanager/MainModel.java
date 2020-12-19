package com.example.choremanager;

public class MainModel {
    String DOTW;
    String date;

    public MainModel (String DOTW, String date){
        this.DOTW = DOTW;
        this.date = date;
    }

    public String getDOTW() {
        return DOTW;
    }
    public String getDate() {
        return date;
    }

}
