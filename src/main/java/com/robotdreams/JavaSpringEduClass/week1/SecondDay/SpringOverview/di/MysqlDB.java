package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.di;

public class MysqlDB implements DatabaseService {

    public String connection;

    public MysqlDB(String connection){
        this.connection = connection;
    }

    @Override
    public void report(){
        System.out.println("send report MYSQL");
    }

}
