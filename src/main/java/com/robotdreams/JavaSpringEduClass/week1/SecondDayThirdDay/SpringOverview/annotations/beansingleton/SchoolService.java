package com.robotdreams.JavaSpringEduClass.week1.SecondDayThirdDay.SpringOverview.annotations.beansingleton;


import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    private final EmployeeService employeeService;

    public SchoolService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void getEmployeeValue(){
        System.out.println(this.employeeService);
    }

}
