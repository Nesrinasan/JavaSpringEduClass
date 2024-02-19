package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.di;

public class ConnectionService {

    public String connection(String type) {
        if(type.equals("Oracle")){
            return "connection url";
        }

        return null;
    }


}
