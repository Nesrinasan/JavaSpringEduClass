package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.di;

public class MysqlDB implements Database {

    public String connection;

    public MysqlDB(String connection){
        this.connection = connection;
    }

    public void report(){
        System.out.println("send report MYSQL");
    }

}
