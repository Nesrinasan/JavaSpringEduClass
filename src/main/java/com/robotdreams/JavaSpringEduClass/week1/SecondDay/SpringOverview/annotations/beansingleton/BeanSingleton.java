package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.annotations.beansingleton;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeanSingleton implements CommandLineRunner {

    private final HospitalService hospitalService;
    private final SchoolService schoolService;

    public BeanSingleton(HospitalService hospitalService, SchoolService schoolService) {
        this.hospitalService = hospitalService;
        this.schoolService = schoolService;
    }

    @Override
    public void run(String... args) throws Exception {

        hospitalService.getEmployeeValue();
        schoolService.getEmployeeValue();
    }
}
