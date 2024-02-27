package com.robotdreams.JavaSpringEduClass.week1.SecondDayThirdDay.SpringOverview.di;

public class ConnectionService {

    public ConnectionService(String s){

    }

    public String connection(String type) {
        if(type.equals("Oracle")){
            return "connection url";
        }else if(type.equals("Mysql")){
            return "conn mysql";
        }

        return null;
    }


}
