package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.annotations;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.Ogretmen;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OgrenciService {
//    static SimpleLogger simpleLogger = new SimpleLogger();
    //Spring classları @Component anotasyonu ile bir spring beani olarak işaretler

    public static void main(String[] args) {
//        simpleLogger.getLevel();


    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}
