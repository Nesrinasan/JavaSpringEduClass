package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.annotations.beansingleton;


import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    private final EmployeeService employeeService;

    public HospitalService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void getEmployeeValue(){
        System.out.println(this.employeeService);
    }

}
