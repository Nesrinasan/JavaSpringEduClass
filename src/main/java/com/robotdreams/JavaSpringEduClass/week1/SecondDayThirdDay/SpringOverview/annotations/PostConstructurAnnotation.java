package com.robotdreams.JavaSpringEduClass.week1.SecondDayThirdDay.SpringOverview.annotations;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostConstructurAnnotation {

    public static List<String> cityList = new ArrayList<>();

    @PostConstruct
    public void testPostConstructur(){
        System.out.println("Context ayağa kalktıktan sonra ilk çağrılan method.");

    }

    @PostConstruct
    public void cityList(){
       cityList.add("Adana");
       cityList.add("Mersin");

    }

}
