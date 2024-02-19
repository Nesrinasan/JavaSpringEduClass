package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.di;

public class OracleDB implements Database {

    public String connection;

    public OracleDB(String connection){
        this.connection = connection;
    }


    public void report(){
        System.out.println("send report");
    }


}
